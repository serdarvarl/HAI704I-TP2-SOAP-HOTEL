package hotel.contrat;

import java.math.BigDecimal;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Confirmation {
    private String idReservation;
    private String idOffre;
    private BigDecimal prixTotal;
    private String carteMasquee;

    public Confirmation() {}

    public String getIdReservation() { return idReservation; }
    public void setIdReservation(String idReservation) { this.idReservation = idReservation; }
    public String getIdOffre() { return idOffre; }
    public void setIdOffre(String idOffre) { this.idOffre = idOffre; }
    public BigDecimal getPrixTotal() { return prixTotal; }
    public void setPrixTotal(BigDecimal prixTotal) { this.prixTotal = prixTotal; }
    public String getCarteMasquee() { return carteMasquee; }
    public void setCarteMasquee(String carteMasquee) { this.carteMasquee = carteMasquee; }
}