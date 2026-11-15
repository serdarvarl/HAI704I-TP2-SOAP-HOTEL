package hotel.contrat;

import jakarta.xml.ws.WebFault;

@WebFault(name = "OffreIndisponible", targetNamespace = "http://hotel.hai704i.umontpellier.fr/")
public class OffreIndisponible extends Exception {
    public OffreIndisponible(String message) { super(message); }
}