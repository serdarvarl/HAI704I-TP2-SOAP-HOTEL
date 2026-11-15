package agence.gen;

import java.math.BigDecimal;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour confirmation complex type.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="confirmation">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="idReservation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="idOffre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         <element name="prixTotal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         <element name="carteMasquee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "confirmation", propOrder = {
    "idReservation",
    "idOffre",
    "prixTotal",
    "carteMasquee"
})
public class Confirmation {

    protected String idReservation;
    protected String idOffre;
    protected BigDecimal prixTotal;
    protected String carteMasquee;

    /**
     * Obtient la valeur de la propriété idReservation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdReservation() {
        return idReservation;
    }

    /**
     * Définit la valeur de la propriété idReservation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdReservation(String value) {
        this.idReservation = value;
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
     * Obtient la valeur de la propriété prixTotal.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrixTotal() {
        return prixTotal;
    }

    /**
     * Définit la valeur de la propriété prixTotal.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrixTotal(BigDecimal value) {
        this.prixTotal = value;
    }

    /**
     * Obtient la valeur de la propriété carteMasquee.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarteMasquee() {
        return carteMasquee;
    }

    /**
     * Définit la valeur de la propriété carteMasquee.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarteMasquee(String value) {
        this.carteMasquee = value;
    }

}
