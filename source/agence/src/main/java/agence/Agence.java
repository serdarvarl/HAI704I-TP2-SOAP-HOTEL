package agence;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.DatatypeFactory;

import agence.gen.AgenceInconnue_Exception;
import agence.gen.AuthentificationRefusee_Exception;
import agence.gen.Confirmation;
import agence.gen.Demande;
import agence.gen.DemandeReservation;
import agence.gen.HotelPort;
import agence.gen.HotelService;
import agence.gen.Offre;
import agence.gen.OffreIndisponible_Exception;
import agence.gen.Paiement;
import agence.gen.PaiementInvalide_Exception;
import jakarta.xml.ws.BindingProvider;
import jakarta.xml.ws.WebServiceException;

public class Agence {

    // une offre et l'hotel d'ou elle vient
    static class OffreHotel {
        Offre offre;
        HotelPort port;
        String adresse;

        OffreHotel(Offre offre, HotelPort port, String adresse) {
            this.offre = offre;
            this.port = port;
            this.adresse = adresse;
        }
    }

    static HotelPort creerPort(String adresse) {
        HotelPort port = new HotelService().getHotelSoapPort();
        Map<String, Object> ctx = ((BindingProvider) port).getRequestContext();
        ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, adresse);
        ctx.put("com.sun.xml.ws.connect.timeout", 2000);
        ctx.put("com.sun.xml.ws.request.timeout", 3000);
        return port;
    }

    public static void main(String[] args) throws Exception {
        String[] adresses = (args.length > 0
                ? args[0] : "http://localhost:8082/hotel,http://localhost:8083/hotel").split(",");
        String idAgence = args.length > 1 ? args[1] : "AG-42";
        String secret = args.length > 2 ? args[2] : "secret-42";

        Demande d = new Demande();
        d.setAgence(idAgence);
        d.setVille("Montpellier");
        d.setArrivee(DatatypeFactory.newInstance().newXMLGregorianCalendar("2026-12-10"));
        d.setDepart(DatatypeFactory.newInstance().newXMLGregorianCalendar("2026-12-13"));
        d.setPersonnes(2);
        d.setEtoilesMin(3);
        d.setPrixMax(new BigDecimal("400"));

        // 1. interroger tous les hotels, sans bloquer si l'un ne repond pas
        List<OffreHotel> toutes = new ArrayList<>();
        for (String adresse : adresses) {
            HotelPort port = creerPort(adresse);
            try {
                for (Offre o : port.chercherOffres(d)) {
                    toutes.add(new OffreHotel(o, port, adresse));
                }
            } catch (AgenceInconnue_Exception e) {
                System.out.println("refus de " + adresse + " : " + e.getMessage());
            } catch (WebServiceException e) {
                System.out.println("hotel injoignable : " + adresse);
            }
        }

        // 2. une seule liste, du moins cher au plus cher
        toutes.sort(Comparator.comparing(x -> x.offre.getPrix()));
        for (OffreHotel x : toutes) {
            Offre o = x.offre;
            System.out.println(o.getId() + " : " + o.getNomHotel() + ", " + o.getEtoiles()
                    + " etoiles, " + o.getLits() + " lits, " + o.getPrix() + " EUR");
        }
        if (toutes.isEmpty()) {
            System.out.println("aucune offre");
            return;
        }

        // 3. reserver la moins chere
        OffreHotel choisie = toutes.get(0);
        try {
            Paiement p = new Paiement();
            p.setNumeroCarte("4111111111111111");
            p.setMoisExpiration(12);
            p.setAnneeExpiration(2030);
            p.setCvc("123");

            DemandeReservation r = new DemandeReservation();
            r.setIdDemande("REQ-" + System.currentTimeMillis());
            r.setAgence(idAgence);
            r.setSecret(secret);
            r.setIdOffre(choisie.offre.getId());
            r.setArrivee(d.getArrivee());
            r.setDepart(d.getDepart());
            r.setNom("Dupont");
            r.setPrenom("Marie");
            r.setPaiement(p);

            Confirmation c = choisie.port.reserver(r);
            System.out.println("reservation : " + c.getIdReservation() + ", " + c.getIdOffre()
                    + ", " + c.getPrixTotal() + " EUR, carte " + c.getCarteMasquee());

            Confirmation c2 = choisie.port.reserver(r);
            System.out.println("rejeu : " + c2.getIdReservation() + " (meme demande)");

        } catch (AuthentificationRefusee_Exception | PaiementInvalide_Exception
                 | OffreIndisponible_Exception e) {
            System.out.println("refus metier : " + e.getMessage());
        } catch (WebServiceException e) {
            System.out.println("panne technique : " + e.getMessage());
        }
    }
}