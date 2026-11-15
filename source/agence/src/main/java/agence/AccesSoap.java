package agence;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

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

//par l'ia  tres complexx !!!!
public class AccesSoap {

    private final Map<String, HotelPort> ports = new HashMap<>();

    private HotelPort port(String adresse) {
        return ports.computeIfAbsent(adresse, a -> {
            HotelPort p = new HotelService().getHotelSoapPort();
            Map<String, Object> ctx = ((BindingProvider) p).getRequestContext();
            ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, a);
            ctx.put("com.sun.xml.ws.connect.timeout", 2000);
            ctx.put("com.sun.xml.ws.request.timeout", 3000);
            return p;
        });
    }

    private XMLGregorianCalendar xml(LocalDate d) {
        try {
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(d.toString());
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public List<OffreAgence> chercher(String adresse, String idAgence, String ville,
                                      LocalDate arrivee, LocalDate depart, int personnes,
                                      int etoilesMin, BigDecimal prixMax) throws ErreurAgence {
        Demande d = new Demande();
        d.setAgence(idAgence);
        d.setVille(ville);
        d.setArrivee(xml(arrivee));
        d.setDepart(xml(depart));
        d.setPersonnes(personnes);
        d.setEtoilesMin(etoilesMin);
        d.setPrixMax(prixMax);
        try {
            List<OffreAgence> resultat = new ArrayList<>();
            for (Offre o : port(adresse).chercherOffres(d)) {
                resultat.add(new OffreAgence(o.getId(), o.getNomHotel(), o.getEtoiles(),
                        o.getLits(), o.getPrix(), adresse));
            }
            return resultat;
        } catch (AgenceInconnue_Exception e) {
            throw new ErreurAgence("l'hotel " + adresse + " refuse cette agence : " + e.getMessage(), true);
        } catch (WebServiceException e) {
            throw new ErreurAgence("hotel injoignable : " + adresse, false);
        }
    }
//par l'ia  tres complexx !!!!
    public String reserver(String adresse, String idAgence, String secret, String idDemande,
                           String idOffre, LocalDate arrivee, LocalDate depart,
                           String nom, String prenom,
                           String numeroCarte, int mois, int annee, String cvc) throws ErreurAgence {
        Paiement p = new Paiement();
        p.setNumeroCarte(numeroCarte);
        p.setMoisExpiration(mois);
        p.setAnneeExpiration(annee);
        p.setCvc(cvc);

        DemandeReservation r = new DemandeReservation();
        r.setIdDemande(idDemande);
        r.setAgence(idAgence);
        r.setSecret(secret);
        r.setIdOffre(idOffre);
        r.setArrivee(xml(arrivee));
        r.setDepart(xml(depart));
        r.setNom(nom);
        r.setPrenom(prenom);
        r.setPaiement(p);
//par l'ia  tres complexx !!!!
        try {
            Confirmation c = port(adresse).reserver(r);
            return c.getIdReservation() + " (" + c.getPrixTotal() + " EUR, carte " + c.getCarteMasquee() + ")";
        } catch (AuthentificationRefusee_Exception e) {
            throw new ErreurAgence("identifiants d'agence refuses : " + e.getMessage(), true);
        } catch (PaiementInvalide_Exception e) {
            throw new ErreurAgence("paiement refuse : " + e.getMessage(), true);
        } catch (OffreIndisponible_Exception e) {
            throw new ErreurAgence("offre indisponible : " + e.getMessage(), true);
        } catch (WebServiceException e) {
            throw new ErreurAgence("hotel injoignable : " + adresse, false);
        }
    }
}