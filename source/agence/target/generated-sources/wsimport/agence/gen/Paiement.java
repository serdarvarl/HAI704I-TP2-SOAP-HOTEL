package agence.gen;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour paiement complex type.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="paiement">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="numeroCarte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="moisExpiration" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="anneeExpiration" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="cvc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "paiement", propOrder = {
    "numeroCarte",
    "moisExpiration",
    "anneeExpiration",
    "cvc"
})
public class Paiement {

    protected String numeroCarte;
    protected int moisExpiration;
    protected int anneeExpiration;
    protected String cvc;

    /**
     * Obtient la valeur de la propriété numeroCarte.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroCarte() {
        return numeroCarte;
    }

    /**
     * Définit la valeur de la propriété numeroCarte.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroCarte(String value) {
        this.numeroCarte = value;
    }

    /**
     * Obtient la valeur de la propriété moisExpiration.
     * 
     */
    public int getMoisExpiration() {
        return moisExpiration;
    }

    /**
     * Définit la valeur de la propriété moisExpiration.
     * 
     */
    public void setMoisExpiration(int value) {
        this.moisExpiration = value;
    }

    /**
     * Obtient la valeur de la propriété anneeExpiration.
     * 
     */
    public int getAnneeExpiration() {
        return anneeExpiration;
    }

    /**
     * Définit la valeur de la propriété anneeExpiration.
     * 
     */
    public void setAnneeExpiration(int value) {
        this.anneeExpiration = value;
    }

    /**
     * Obtient la valeur de la propriété cvc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCvc() {
        return cvc;
    }

    /**
     * Définit la valeur de la propriété cvc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCvc(String value) {
        this.cvc = value;
    }

}
