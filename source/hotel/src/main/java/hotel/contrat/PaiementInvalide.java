package hotel.contrat;

import jakarta.xml.ws.WebFault;

@WebFault(name = "PaiementInvalide", targetNamespace = "http://hotel.hai704i.umontpellier.fr/")
public class PaiementInvalide extends Exception {
    public PaiementInvalide(String message) { super(message); }
}