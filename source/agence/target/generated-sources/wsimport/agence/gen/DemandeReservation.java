package agence.gen;

import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour demandeReservation complex type.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="demandeReservation">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="idDemande" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="agence" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="secret" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="idOffre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="arrivee" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         <element name="depart" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         <element name="nom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="prenom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="paiement" type="{http://hotel.hai704i.umontpellier.fr/}paiement" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "demandeReservation", propOrder = {
    "idDemande",
    "agence",
    "secret",
    "idOffre",
    "arrivee",
    "depart",
    "nom",
    "prenom",
    "paiement"
})
public class DemandeReservation {

    protected String idDemande;
    protected String agence;
    protected String secret;
    protected String idOffre;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar arrivee;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar depart;
    protected String nom;
    protected String prenom;
    protected Paiement paiement;

    /**
     * Obtient la valeur de la propriété idDemande.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdDemande() {
        return idDemande;
    }

    /**
     * Définit la valeur de la propriété idDemande.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdDemande(String value) {
        this.idDemande = value;
    }

    /**
     * Obtient la valeur de la propriété agence.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgence() {
        return agence;
    }

    /**
     * Définit la valeur de la propriété agence.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgence(String value) {
        this.agence = value;
    }

    /**
     * Obtient la valeur de la propriété secret.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecret() {
        return secret;
    }

    /**
     * Définit la valeur de la propriété secret.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecret(String value) {
        this.secret = value;
    }

    /**
     * Obtient la valeur de la propriété idOffre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdOffre() {
        return idOffre;
    }

    /**
     * Définit la valeur de la propriété idOffre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdOffre(String value) {
        this.idOffre = value;
    }

    /**
     * Obtient la valeur de la propriété arrivee.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getArrivee() {
        return arrivee;
    }

    /**
     * Définit la valeur de la propriété arrivee.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setArrivee(XMLGregorianCalendar value) {
        this.arrivee = value;
    }

    /**
     * Obtient la valeur de la propriété depart.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDepart() {
        return depart;
    }

    /**
     * Définit la valeur de la propriété depart.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDepart(XMLGregorianCalendar value) {
        this.depart = value;
    }

    /**
     * Obtient la valeur de la propriété nom.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit la valeur de la propriété nom.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNom(String value) {
        this.nom = value;
    }

    /**
     * Obtient la valeur de la propriété prenom.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Définit la valeur de la propriété prenom.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrenom(String value) {
        this.prenom = value;
    }

    /**
     * Obtient la valeur de la propriété paiement.
     * 
     * @return
     *     possible object is
     *     {@link Paiement }
     *     
     */
    public Paiement getPaiement() {
        return paiement;
    }

    /**
     * Définit la valeur de la propriété paiement.
     * 
     * @param value
     *     allowed object is
     *     {@link Paiement }
     *     
     */
    public void setPaiement(Paiement value) {
        this.paiement = value;
    }

}
