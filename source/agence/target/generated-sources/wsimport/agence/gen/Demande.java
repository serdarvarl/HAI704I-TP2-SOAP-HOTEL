package agence.gen;

import java.math.BigDecimal;
import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour demande complex type.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="demande">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="agence" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="ville" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="arrivee" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         <element name="depart" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         <element name="personnes" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="etoilesMin" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="prixMax" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "demande", propOrder = {
    "agence",
    "ville",
    "arrivee",
    "depart",
    "personnes",
    "etoilesMin",
    "prixMax"
})
public class Demande {

    protected String agence;
    protected String ville;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar arrivee;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar depart;
    protected int personnes;
    protected int etoilesMin;
    protected BigDecimal prixMax;

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
     * Obtient la valeur de la propriété ville.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVille() {
        return ville;
    }

    /**
     * Définit la valeur de la propriété ville.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVille(String value) {
        this.ville = value;
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
     * Obtient la valeur de la propriété personnes.
     * 
     */
    public int getPersonnes() {
        return personnes;
    }

    /**
     * Définit la valeur de la propriété personnes.
     * 
     */
    public void setPersonnes(int value) {
        this.personnes = value;
    }

    /**
     * Obtient la valeur de la propriété etoilesMin.
     * 
     */
    public int getEtoilesMin() {
        return etoilesMin;
    }

    /**
     * Définit la valeur de la propriété etoilesMin.
     * 
     */
    public void setEtoilesMin(int value) {
        this.etoilesMin = value;
    }

    /**
     * Obtient la valeur de la propriété prixMax.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrixMax() {
        return prixMax;
    }

    /**
     * Définit la valeur de la propriété prixMax.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrixMax(BigDecimal value) {
        this.prixMax = value;
    }

}
