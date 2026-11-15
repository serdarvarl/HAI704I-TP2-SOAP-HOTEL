package hotel.service;

import java.math.BigDecimal;

public class Chambre {

    private final String id;
    private final String nomHotel;
    private final String ville;
    private final int etoiles;
    private final int lits;
    private final BigDecimal prixParNuit;

    public Chambre(String id, String nomHotel, String ville, int etoiles, int lits, BigDecimal prixParNuit) {
        this.id = id;
        this.nomHotel = nomHotel;
        this.ville = ville;
        this.etoiles = etoiles;
        this.lits = lits;
        this.prixParNuit = prixParNuit;
    }

    public String getId() {
        return id;
    }

    public String getNomHotel() {
        return nomHotel;
    }

    public String getVille() {
        return ville;
    }

    public int getEtoiles() {
        return etoiles;
    }

    public int getLits() {
        return lits;
    }

    public BigDecimal getPrixParNuit() {
        return prixParNuit;
    }
}