package agence;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

//par l'ia
public class Console {

    static Scanner in = new Scanner(System.in);

    static String lire(String question) {
        while (true) {
            System.out.print(question + " : ");
            String s = in.nextLine().trim();
            if (!s.isEmpty()) {
                return s;
            }
            System.out.println("  champ vide, recommencez");
        }
    }

    static int lireEntier(String question) {
        while (true) {
            try {
                return Integer.parseInt(lire(question));
            } catch (NumberFormatException e) {
                System.out.println("  nombre invalide, recommencez");
            }
        }
    }

    static LocalDate lireDate(String question) {
        while (true) {
            try {
                return LocalDate.parse(lire(question + " (AAAA-MM-JJ)"));
            } catch (Exception e) {
                System.out.println("  date invalide, format attendu AAAA-MM-JJ");
            }
        }
    }

    static void afficher(List<OffreAgence> offres) {
        if (offres.isEmpty()) {
            System.out.println("aucune offre");
            return;
        }
        for (int i = 0; i < offres.size(); i++) {
            OffreAgence o = offres.get(i);
            System.out.println((i + 1) + ") " + o.nomHotel + " " + o.id + ", " + o.etoiles
                    + " etoiles, " + o.lits + " lits, " + o.prix + " EUR");
        }
    }

    static void rechercher(LogiqueAgence agence) {
        String ville = lire("ville");
        LocalDate arrivee = lireDate("arrivee");
        LocalDate depart = lireDate("depart");
        if (!depart.isAfter(arrivee)) {
            System.out.println("  le depart doit etre apres l'arrivee");
            return;
        }
        int personnes = lireEntier("nombre de personnes");
        int etoiles = lireEntier("etoiles minimum");
        int prixMax = lireEntier("prix maximum (EUR)");

        agence.rechercher(ville, arrivee, depart, personnes, etoiles, BigDecimal.valueOf(prixMax));
        for (String incident : agence.getIncidents()) {
            System.out.println("  ! " + incident);
        }
        afficher(agence.getOffres());
    }

    static void reserver(LogiqueAgence agence) {
        List<OffreAgence> offres = agence.getOffres();
        if (offres.isEmpty()) {
            System.out.println("  faites d'abord une recherche");
            return;
        }
        afficher(offres);
        int n = lireEntier("numero de l'offre");
        if (n < 1 || n > offres.size()) {
            System.out.println("  numero hors liste");
            return;
        }
        String nom = lire("nom");
        String prenom = lire("prenom");
        String carte = lire("numero de carte (fictif)");
        int mois = lireEntier("mois d'expiration");
        int annee = lireEntier("annee d'expiration");
        String cvc = lire("cvc");

        try {
            String ref = agence.reserver(n, nom, prenom, carte, mois, annee, cvc);
            System.out.println("reservation confirmee : " + ref);
        } catch (ErreurAgence e) {
            if (e.estMetier()) {
                System.out.println("  refus de l'hotel : " + e.getMessage());
            } else {
                System.out.println("  probleme technique : " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("usage : Console <adresses separees par des virgules> <idAgence> <secret>");
            return;
        }
        LogiqueAgence agence = new LogiqueAgence(Arrays.asList(args[0].split(",")), args[1], args[2]);

        try {
            while (true) {
                System.out.println();
                System.out.println("1) rechercher un sejour");
                System.out.println("2) reserver une offre");
                System.out.println("0) quitter");
                String choix = lire("choix");
                if (choix.equals("1")) {
                    rechercher(agence);
                } else if (choix.equals("2")) {
                    reserver(agence);
                } else if (choix.equals("0")) {
                    System.out.println("au revoir");
                    return;
                } else {
                    System.out.println("  choix inconnu");
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("au revoir");
        }
    }
}