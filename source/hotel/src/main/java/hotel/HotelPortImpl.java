package hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import hotel.contrat.AgenceInconnue;
import hotel.contrat.AuthentificationRefusee;
import hotel.contrat.Confirmation;
import hotel.contrat.Demande;
import hotel.contrat.DemandeReservation;
import hotel.contrat.HotelPort;
import hotel.contrat.Offre;
import hotel.contrat.OffreIndisponible;
import hotel.contrat.Paiement;
import hotel.contrat.PaiementInvalide;
import hotel.service.Proposition;
import hotel.service.Reservation;
import hotel.service.ServiceHotel;
import jakarta.jws.WebService;

@WebService(endpointInterface = "hotel.contrat.HotelPort",
            serviceName = "HotelService",
            portName = "HotelSoapPort",
            targetNamespace = "http://hotel.hai704i.umontpellier.fr/")
public class HotelPortImpl implements HotelPort {

    private final ServiceHotel service;

    public HotelPortImpl(ServiceHotel service) {
        this.service = service;
    }

    

    @Override
    public List<Offre> chercherOffres(Demande demande) throws AgenceInconnue { // changer A3
        if (!service.estPartenaire(demande.getAgence())) {
            throw new AgenceInconnue("agence " + demande.getAgence() + " non partenaire");
        }

        LocalDate arrivee = versLocalDate(demande.getArrivee());
        LocalDate depart = versLocalDate(demande.getDepart());

        List<Proposition> propositions = service.chercher(demande.getAgence(),demande.getVille(), arrivee, depart, // ajouter agence
                demande.getPersonnes(), demande.getEtoilesMin(), demande.getPrixMax());

        List<Offre> offres = new ArrayList<>();
        for (Proposition p : propositions) {
            offres.add(new Offre(p.getChambre().getId(),
                                 p.getChambre().getNomHotel(),
                                 p.getChambre().getVille(),
                                 p.getChambre().getEtoiles(),
                                 p.getChambre().getLits(),
                                 p.getPrixTotal()));
        }
        return offres;
    }



      @Override
    public Confirmation reserver(DemandeReservation r)
            throws AuthentificationRefusee, PaiementInvalide, OffreIndisponible {

        // 1. qui appelle ? (avant tout le reste)
        if (!service.authentifier(r.getAgence(), r.getSecret())) {
            throw new AuthentificationRefusee("agence ou secret refuse");
        }

        // 2. rejeu : meme agence + meme idDemande -> meme reponse, rien de nouveau
        String cle = r.getAgence() + ":" + r.getIdDemande();
        Reservation deja = service.dejaVue(cle);
        if (deja != null) {
            return versConfirmation(deja);
        }

        // 3. paiement
        Paiement p = r.getPaiement();
        if (p == null) {
            throw new PaiementInvalide("paiement manquant");
        }
        String erreur = service.verifierPaiement(p.getNumeroCarte(),
                p.getMoisExpiration(), p.getAnneeExpiration(), p.getCvc());
        if (erreur != null) {
            throw new PaiementInvalide(erreur);
        }

        // 4. disponibilite + enregistrement
        Reservation res = service.reserver(cle,r.getAgence() ,r.getIdOffre(),
                versLocalDate(r.getArrivee()), versLocalDate(r.getDepart()),
                service.masquer(p.getNumeroCarte()));
        if (res == null) {
            throw new OffreIndisponible("offre " + r.getIdOffre() + " indisponible");
        }
        return versConfirmation(res);
    }

    private Confirmation versConfirmation(Reservation res) {
        Confirmation c = new Confirmation();
        c.setIdReservation(res.getIdReservation());
        c.setIdOffre(res.getIdOffre());
        c.setPrixTotal(res.getPrixTotal());
        c.setCarteMasquee(res.getCarteMasquee());
        return c;
    }

    private LocalDate versLocalDate(XMLGregorianCalendar d) {
        return LocalDate.of(d.getYear(), d.getMonth(), d.getDay());
    }
}