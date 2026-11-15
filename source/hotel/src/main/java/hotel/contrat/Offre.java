package hotel.contrat;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class Offre {

    private String id;

    private String nomHotel;

    private String ville;

    private int etoiles;

    private int lits;

    private BigDecimal prix;

    public Offre() {
    }

    public Offre(String id, String nomHotel, String ville, int etoiles, int lits, BigDecimal prix) {
        this.id = id;
        this.nomHotel = nomHotel;
        this.ville = ville;
        this.etoiles = etoiles;
        this.lits = lits;
        this.prix = prix;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomHotel() {
        return nomHotel;
    }

    public void setNomHotel(String nomHotel) {
        this.nomHotel = nomHotel;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getEtoiles() {
        return etoiles;
    }

    public void setEtoiles(int etoiles) {
        this.etoiles = etoiles;
    }

    public int getLits() {
        return lits;
    }

    public void setLits(int lits) {
        this.lits = lits;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }
}