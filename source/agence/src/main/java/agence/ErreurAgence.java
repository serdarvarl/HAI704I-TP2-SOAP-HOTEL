package agence;

public class ErreurAgence extends Exception {
    private final boolean metier; // true = refus de l'hotel, false = panne technique

    public ErreurAgence(String message, boolean metier) {
        super(message);
        this.metier = metier;
    }

    public boolean estMetier() {
        return metier;
    }
} 
    

