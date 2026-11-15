package hotel.contrat;

import javax.xml.datatype.XMLGregorianCalendar;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSchemaType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DemandeReservation {
    private String idDemande;
    private String agence;
    private String secret;
    private String idOffre;
    @XmlSchemaType(name = "date")
    private XMLGregorianCalendar arrivee;
    @XmlSchemaType(name = "date")
    private XMLGregorianCalendar depart;
    private String nom;
    private String prenom;
    private Paiement paiement;

    public DemandeReservation() {}

    public String getIdDemande() { return idDemande; }
    public void setIdDemande(String idDemande) { this.idDemande = idDemande; }
    public String getAgence() { return agence; }
    public void setAgence(String agence) { this.agence = agence; }
    public String getSecret() { return secret; }
    public void setSecret(String secret) { this.secret = secret; }
    public String getIdOffre() { return idOffre; }
    public void setIdOffre(String idOffre) { this.idOffre = idOffre; }
    public XMLGregorianCalendar getArrivee() { return arrivee; }
    public void setArrivee(XMLGregorianCalendar arrivee) { this.arrivee = arrivee; }
    public XMLGregorianCalendar getDepart() { return depart; }
    public void setDepart(XMLGregorianCalendar depart) { this.depart = depart; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public Paiement getPaiement() { return paiement; }
    public void setPaiement(Paiement paiement) { this.paiement = paiement; }
}