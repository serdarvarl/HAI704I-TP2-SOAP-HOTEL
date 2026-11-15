package hotel.contrat;

import jakarta.xml.ws.WebFault;

@WebFault(name = "AuthentificationRefusee", targetNamespace = "http://hotel.hai704i.umontpellier.fr/")
public class AuthentificationRefusee extends Exception {
    public AuthentificationRefusee(String message) { super(message); }
}