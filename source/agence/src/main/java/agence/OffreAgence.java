package agence;

import java.math.BigDecimal;

public class OffreAgence {
    public final String id;
    public final String nomHotel;
    public final int etoiles;
    public final int lits;
    public final BigDecimal prix;
    public final String adresse; // l'hotel d'ou vient l'offre

    public OffreAgence(String id, String nomHotel, int etoiles, int lits,
                       BigDecimal prix, String adresse) {
        this.id = id;
        this.nomHotel = nomHotel;
        this.etoiles = etoiles;
        this.lits = lits;
        this.prix = prix;
        this.adresse = adresse;
    }
}