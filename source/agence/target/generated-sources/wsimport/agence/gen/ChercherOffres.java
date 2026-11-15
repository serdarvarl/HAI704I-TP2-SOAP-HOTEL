package agence.gen;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour chercherOffres complex type.</p>
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.</p>
 * 
 * <pre>{@code
 * <complexType name="chercherOffres">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="demande" type="{http://hotel.hai704i.umontpellier.fr/}demande" minOccurs="0"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "chercherOffres", propOrder = {
    "demande"
})
public class ChercherOffres {

    protected Demande demande;

    /**
     * Obtient la valeur de la propriété demande.
     * 
     * @return
     *     possible object is
     *     {@link Demande }
     *     
     */
    public Demande getDemande() {
        return demande;
    }

    /**
     * Définit la valeur de la propriété demande.
     * 
     * @param value
     *     allowed object is
     *     {@link Demande }
     *     
     */
    public void setDemande(Demande value) {
        this.demande = value;
    }

}
