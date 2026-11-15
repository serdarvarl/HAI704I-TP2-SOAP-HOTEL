package agence.gen;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the agence.gen package. 
 * <p>An ObjectFactory allows you to programmatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private static final QName _AgenceInconnue_QNAME = new QName("http://hotel.hai704i.umontpellier.fr/", "AgenceInconnue");
    private static final QName _AuthentificationRefusee_QNAME = new QName("http://hotel.hai704i.umontpellier.fr/", "AuthentificationRefusee");
    private static final QName _OffreIndisponible_QNAME = new QName("http://hotel.hai704i.umontpellier.fr/", "OffreIndisponible");
    private static final QName _PaiementInvalide_QNAME = new QName("http://hotel.hai704i.umontpellier.fr/", "PaiementInvalide");
    private static final QName _ChercherOffres_QNAME = new QName("http://hotel.hai704i.umontpellier.fr/", "chercherOffres");
    private static final QName _ChercherOffresResponse_QNAME = new QName("http://hotel.hai704i.umontpellier.fr/", "chercherOffresResponse");
    private static final QName _Reserver_QNAME = new QName("http://hotel.hai704i.umontpellier.fr/", "reserver");
    private static final QName _ReserverResponse_QNAME = new QName("http://hotel.hai704i.umontpellier.fr/", "reserverResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: agence.gen
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AgenceInconnue }
     * 
     * @return
     *     the new instance of {@link AgenceInconnue }
     */
    public AgenceInconnue createAgenceInconnue() {
        return new AgenceInconnue();
    }

    /**
     * Create an instance of {@link AuthentificationRefusee }
     * 
     * @return
     *     the new instance of {@link AuthentificationRefusee }
     */
    public AuthentificationRefusee createAuthentificationRefusee() {
        return new AuthentificationRefusee();
    }

    /**
     * Create an instance of {@link OffreIndisponible }
     * 
     * @return
     *     the new instance of {@link OffreIndisponible }
     */
    public OffreIndisponible createOffreIndisponible() {
        return new OffreIndisponible();
    }

    /**
     * Create an instance of {@link PaiementInvalide }
     * 
     * @return
     *     the new instance of {@link PaiementInvalide }
     */
    public PaiementInvalide createPaiementInvalide() {
        return new PaiementInvalide();
    }

    /**
     * Create an instance of {@link ChercherOffres }
     * 
     * @return
     *     the new instance of {@link ChercherOffres }
     */
    public ChercherOffres createChercherOffres() {
        return new ChercherOffres();
    }

    /**
     * Create an instance of {@link ChercherOffresResponse }
     * 
     * @return
     *     the new instance of {@link ChercherOffresResponse }
     */
    public ChercherOffresResponse createChercherOffresResponse() {
        return new ChercherOffresResponse();
    }

    /**
     * Create an instance of {@link Reserver }
     * 
     * @return
     *     the new instance of {@link Reserver }
     */
    public Reserver createReserver() {
        return new Reserver();
    }

    /**
     * Create an instance of {@link ReserverResponse }
     * 
     * @return
     *     the new instance of {@link ReserverResponse }
     */
    public ReserverResponse createReserverResponse() {
        return new ReserverResponse();
    }

    /**
     * Create an instance of {@link DemandeReservation }
     * 
     * @return
     *     the new instance of {@link DemandeReservation }
     */
    public DemandeReservation createDemandeReservation() {
        return new DemandeReservation();
    }

    /**
     * Create an instance of {@link Paiement }
     * 
     * @return
     *     the new instance of {@link Paiement }
     */
    public Paiement createPaiement() {
        return new Paiement();
    }

    /**
     * Create an instance of {@link Confirmation }
     * 
     * @return
     *     the new instance of {@link Confirmation }
     */
    public Confirmation createConfirmation() {
        return new Confirmation();
    }

    /**
     * Create an instance of {@link Demande }
     * 
     * @return
     *     the new instance of {@link Demande }
     */
    public Demande createDemande() {
        return new Demande();
    }

    /**
     * Create an instance of {@link Offre }
     * 
     * @return
     *     the new instance of {@link Offre }
     */
    public Offre createOffre() {
        return new Offre();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgenceInconnue }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AgenceInconnue }{@code >}
     */
    @XmlElementDecl(namespace = "http://hotel.hai704i.umontpellier.fr/", name = "AgenceInconnue")
    public JAXBElement<AgenceInconnue> createAgenceInconnue(AgenceInconnue value) {
        return new JAXBElement<>(_AgenceInconnue_QNAME, AgenceInconnue.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthentificationRefusee }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AuthentificationRefusee }{@code >}
     */
    @XmlElementDecl(namespace = "http://hotel.hai704i.umontpellier.fr/", name = "AuthentificationRefusee")
    public JAXBElement<AuthentificationRefusee> createAuthentificationRefusee(AuthentificationRefusee value) {
        return new JAXBElement<>(_AuthentificationRefusee_QNAME, AuthentificationRefusee.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OffreIndisponible }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OffreIndisponible }{@code >}
     */
    @XmlElementDecl(namespace = "http://hotel.hai704i.umontpellier.fr/", name = "OffreIndisponible")
    public JAXBElement<OffreIndisponible> createOffreIndisponible(OffreIndisponible value) {
        return new JAXBElement<>(_OffreIndisponible_QNAME, OffreIndisponible.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaiementInvalide }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PaiementInvalide }{@code >}
     */
    @XmlElementDecl(namespace = "http://hotel.hai704i.umontpellier.fr/", name = "PaiementInvalide")
    public JAXBElement<PaiementInvalide> createPaiementInvalide(PaiementInvalide value) {
        return new JAXBElement<>(_PaiementInvalide_QNAME, PaiementInvalide.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChercherOffres }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChercherOffres }{@code >}
     */
    @XmlElementDecl(namespace = "http://hotel.hai704i.umontpellier.fr/", name = "chercherOffres")
    public JAXBElement<ChercherOffres> createChercherOffres(ChercherOffres value) {
        return new JAXBElement<>(_ChercherOffres_QNAME, ChercherOffres.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChercherOffresResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChercherOffresResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://hotel.hai704i.umontpellier.fr/", name = "chercherOffresResponse")
    public JAXBElement<ChercherOffresResponse> createChercherOffresResponse(ChercherOffresResponse value) {
        return new JAXBElement<>(_ChercherOffresResponse_QNAME, ChercherOffresResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Reserver }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Reserver }{@code >}
     */
    @XmlElementDecl(namespace = "http://hotel.hai704i.umontpellier.fr/", name = "reserver")
    public JAXBElement<Reserver> createReserver(Reserver value) {
        return new JAXBElement<>(_Reserver_QNAME, Reserver.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReserverResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReserverResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://hotel.hai704i.umontpellier.fr/", name = "reserverResponse")
    public JAXBElement<ReserverResponse> createReserverResponse(ReserverResponse value) {
        return new JAXBElement<>(_ReserverResponse_QNAME, ReserverResponse.class, null, value);
    }

}
