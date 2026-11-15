package hotel.contrat;

import java.util.List;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

@WebService(name = "HotelPort",
            targetNamespace = "http://hotel.hai704i.umontpellier.fr/")
public interface HotelPort {

    @WebMethod
    @WebResult(name = "offre")
    List<Offre> chercherOffres(@WebParam(name = "demande") Demande demande) throws AgenceInconnue; // pour eerrur

    
    @WebMethod
    @WebResult(name = "confirmation")
    Confirmation reserver(@WebParam(name = "reservation") DemandeReservation reservation)
            throws AuthentificationRefusee, PaiementInvalide, OffreIndisponible;

}