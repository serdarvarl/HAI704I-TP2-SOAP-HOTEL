package hotel.service;

import java.time.LocalDate;

public class ValidationPaiement {

    // retourne null si tout est correct, sinon le message d'erreur
    public String verifier(String numero, int mois, int annee, String cvc) { // sinon nulll anexee
        if (numero == null || !numero.matches("\\d{13,19}")) { // avec regex cherhcer chifre comme vria card
            return "numero de carte invalide";
        }
        if (mois < 1 || mois > 12) {
            return "mois d'expiration invalide";
        }
        LocalDate auj = LocalDate.now();
        if (annee < auj.getYear() || (annee == auj.getYear() && mois < auj.getMonthValue())) {
            return "carte expiree";
        }
        if (cvc == null || !cvc.matches("\\d{3,4}")) { 
            return "cvc invalide";
        }
        return null;
    }

    public String masquer(String numero) { // chacher les chifre
        return "**** " + numero.substring(numero.length() - 4);
    }
}