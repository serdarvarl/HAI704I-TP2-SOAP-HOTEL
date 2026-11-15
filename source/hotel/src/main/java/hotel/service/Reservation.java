package hotel.service;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Reservation {
    private final String idReservation;
    private final String idOffre;
    private final LocalDate arrivee;
    private final LocalDate depart;
    private final BigDecimal prixTotal;
    private final String carteMasquee;

    public Reservation(String idReservation, String idOffre, LocalDate arrivee,
                       LocalDate depart, BigDecimal prixTotal, String carteMasquee) {
        this.idReservation = idReservation;
        this.idOffre = idOffre;
        this.arrivee = arrivee;
        this.depart = depart;
        this.prixTotal = prixTotal;
        this.carteMasquee = carteMasquee;
    }

    public String getIdReservation() { return idReservation; }
    public String getIdOffre() { return idOffre; }
    public LocalDate getArrivee() { return arrivee; }
    public LocalDate getDepart() { return depart; }
    public BigDecimal getPrixTotal() { return prixTotal; }
    public String getCarteMasquee() { return carteMasquee; }
}