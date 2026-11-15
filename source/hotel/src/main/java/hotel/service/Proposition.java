package hotel.service;

import java.math.BigDecimal;

public class Proposition {

    private final Chambre chambre;
    private final int nuits;
    private final BigDecimal prixTotal;

    public Proposition(Chambre chambre, int nuits, BigDecimal prixTotal) {
        this.chambre = chambre;
        this.nuits = nuits;
        this.prixTotal = prixTotal;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public int getNuits() {
        return nuits;
    }

    public BigDecimal getPrixTotal() {
        return prixTotal;
    }
}