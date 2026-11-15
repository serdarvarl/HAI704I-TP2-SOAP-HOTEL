package hotel.contrat;

import jakarta.xml.ws.WebFault;

@WebFault(name = "AgenceInconnue",
          targetNamespace = "http://hotel.hai704i.umontpellier.fr/")
public class AgenceInconnue extends Exception {

    public AgenceInconnue(String message) {
        super(message);
    }
}