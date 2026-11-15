package agence.gen;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour reserverResponse complex type.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="reserverResponse">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="confirmation" type="{http://hotel.hai704i.umontpellier.fr/}confirmation" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reserverResponse", propOrder = {
    "confirmation"
})
public class ReserverResponse {

    protected Confirmation confirmation;

    /**
     * Obtient la valeur de la propriété confirmation.
     * 
     * @return
     *     possible object is
     *     {@link Confirmation }
     *     
     */
    public Confirmation getConfirmation() {
        return confirmation;
    }

    /**
     * Définit la valeur de la propriété confirmation.
     * 
     * @param value
     *     allowed object is
     *     {@link Confirmation }
     *     
     */
    public void setConfirmation(Confirmation value) {
        this.confirmation = value;
    }

}
