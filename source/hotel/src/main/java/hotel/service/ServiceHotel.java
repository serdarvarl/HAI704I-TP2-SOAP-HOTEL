package hotel.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import hotel.depot.ChambreDepot;

public class ServiceHotel {

    private final ChambreDepot depot;

    private static final Set<String> PARTENAIRES = Set.of("AG-42", "AG-77"); // A3 veriefer si refus

    public ServiceHotel(ChambreDepot depot) {
        this.depot = depot;
    }


    private final Authentification auth = new Authentification();
    private final ValidationPaiement paiement = new ValidationPaiement();
    private final Map<String, Reservation> parDemande = new HashMap<>();
    private final List<Reservation> reservations = new ArrayList<>();
    private int compteur = 0;

    public boolean authentifier(String agence, String secret) {
        return auth.verifier(agence, secret);
    }

    public String verifierPaiement(String numero, int mois, int annee, String cvc) {
        return paiement.verifier(numero, mois, annee, cvc);
    }

    public String masquer(String numero) {
        return paiement.masquer(numero);
    }

    public synchronized Reservation dejaVue(String idDemande) {
        return parDemande.get(idDemande);
    }

    // retourne null si la chambre n'existe pas ou n'est pas libre
    public synchronized Reservation reserver(String idDemande,String agence,String idOffre, // ajouté agence verifier si erruer !!!
                                             LocalDate arrivee, LocalDate depart, String carteMasquee) {
        Chambre chambre = null;
        for (Chambre c : depot.toutes()) {
            if (c.getId().equals(idOffre)) {
                chambre = c;
            }
        }
        if (chambre == null) {
            return null;
        }
        for (Reservation r : reservations) {
            if (r.getIdOffre().equals(idOffre)
                    && arrivee.isBefore(r.getDepart()) && depart.isAfter(r.getArrivee())) {
                return null;
            }
        }
        long nuits = ChronoUnit.DAYS.between(arrivee, depart);
        BigDecimal total = tarif(agence, chambre.getPrixParNuit().multiply(BigDecimal.valueOf(nuits)));
        //BigDecimal total = chambre.getPrixParNuit().multiply(BigDecimal.valueOf(nuits)); si toujour ererurr verfier ??
        compteur++;
        Reservation r = new Reservation("RES-" + compteur, idOffre, arrivee, depart, total, carteMasquee);
        reservations.add(r);
        parDemande.put(idDemande, r);
        return r;
    }

    public boolean estPartenaire(String agence) {
        return agence != null && PARTENAIRES.contains(agence);

      
    }

    // diffrent prix
    private BigDecimal tarif(String agence, BigDecimal total) {
        if ("AG-77".equals(agence)) {
            return total.multiply(new BigDecimal("0.90")).setScale(2, java.math.RoundingMode.HALF_UP);
        }
        return total;



    }

    public List<Proposition> chercher(String agence,String ville, LocalDate arrivee, LocalDate depart, // y avait erurre ortoograph
                                      int personnes, int etoilesMin, BigDecimal prixMax) {
        long nuits = ChronoUnit.DAYS.between(arrivee, depart);
        List<Proposition> resultat = new ArrayList<>();
        for (Chambre c : depot.toutes()) {
            if (!c.getVille().equalsIgnoreCase(ville)) {
                continue;
            }
            if (c.getEtoiles() < etoilesMin) {
                continue;
            }
            if (c.getLits() < personnes) {
                continue;
            }
            BigDecimal total = tarif(agence, c.getPrixParNuit().multiply(BigDecimal.valueOf(nuits))); //ajouté agenc pour differnr prix
            //BigDecimal total = c.getPrixParNuit().multiply(BigDecimal.valueOf(nuits)); 
            if (prixMax != null && total.compareTo(prixMax) > 0) {
                continue;
            }
            resultat.add(new Proposition(c, (int) nuits, total));
        }
        return resultat;
    }
}