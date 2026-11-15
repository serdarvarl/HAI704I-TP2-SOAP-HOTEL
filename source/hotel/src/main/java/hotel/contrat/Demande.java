package hotel.contrat;


import java.math.BigDecimal;

import javax.xml.datatype.XMLGregorianCalendar;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSchemaType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Demande {

    private String agence; //A3 agencee

    private String ville;



    @XmlSchemaType(name="date")
        private XMLGregorianCalendar arrivee;

    @XmlSchemaType(name="date")
        private XMLGregorianCalendar depart;

    private int personnes;

    private  int etoilesMin;

    private BigDecimal prixMax;


    public Demande() {


    }

    
    public Demande(String agence ,String ville, XMLGregorianCalendar arrivee, XMLGregorianCalendar depart,
                   int personnes, int etoilesMin, BigDecimal prixMax) {
        this.agence = agence ; // ajouté
        this.ville = ville;
        this.arrivee = arrivee;
        this.depart = depart;
        this.personnes = personnes;
        this.etoilesMin = etoilesMin;
        this.prixMax = prixMax;
    }


    public String getAgence() {
        return agence;
    }

    public void setAgence(String agence) {
        this.agence = agence;
    }



     public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public XMLGregorianCalendar getArrivee() {
        return arrivee;
    }

    public void setArrivee(XMLGregorianCalendar arrivee) {
        this.arrivee = arrivee;
    }

    public XMLGregorianCalendar getDepart() {
        return depart;
    }

    public void setDepart(XMLGregorianCalendar depart) {
        this.depart = depart;
    }

    public int getPersonnes() {
        return personnes;
    }

    public void setPersonnes(int personnes) {
        this.personnes = personnes;
    }

    public int getEtoilesMin() {
        return etoilesMin;
    }

    public void setEtoilesMin(int etoilesMin) {
        this.etoilesMin = etoilesMin;
    }

    public BigDecimal getPrixMax() {
        return prixMax;
    }

    public void setPrixMax(BigDecimal prixMax) {
        this.prixMax = prixMax;
    }




}