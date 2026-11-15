package agence;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

// par l'ia
public class LogiqueAgence {

    private final AccesSoap soap = new AccesSoap();
    private final List<String> adresses;
    private final String idAgence;
    private final String secret;

    private List<OffreAgence> offres = new ArrayList<>();
    private List<String> incidents = new ArrayList<>();
    private LocalDate arrivee;
    private LocalDate depart;

    public LogiqueAgence(List<String> adresses, String idAgence, String secret) {
        this.adresses = adresses;
        this.idAgence = idAgence;
        this.secret = secret;
    }

    public void rechercher(String ville, LocalDate arrivee, LocalDate depart,
                           int personnes, int etoilesMin, BigDecimal prixMax) {
        List<OffreAgence> toutes = new ArrayList<>();
        List<String> pannes = new ArrayList<>();
        for (String adresse : adresses) {
            try {
                toutes.addAll(soap.chercher(adresse, idAgence, ville, arrivee, depart,
                        personnes, etoilesMin, prixMax));
            } catch (ErreurAgence e) {
                pannes.add(e.getMessage());
            }
        }
        toutes.sort(Comparator.comparing(o -> o.prix));
        this.offres = toutes;
        this.incidents = pannes;
        this.arrivee = arrivee;
        this.depart = depart;
    }

    public List<OffreAgence> getOffres() {
        return offres;
    }

    public List<String> getIncidents() {
        return incidents;
    }

    // numero = position dans la liste affichee (1, 2, 3...)
    public String reserver(int numero, String nom, String prenom,
                           String numeroCarte, int mois, int annee, String cvc) throws ErreurAgence {
        OffreAgence o = offres.get(numero - 1);
        return soap.reserver(o.adresse, idAgence, secret, "REQ-" + UUID.randomUUID(), o.id,
                arrivee, depart, nom, prenom, numeroCarte, mois, annee, cvc);
    }
}