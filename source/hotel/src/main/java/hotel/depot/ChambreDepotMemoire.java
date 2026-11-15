package hotel.depot;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import hotel.service.Chambre;

public class ChambreDepotMemoire implements ChambreDepot {

    private final List<Chambre> chambres = new ArrayList<>();

    //ajouter plusier hotel et chamre
    public ChambreDepotMemoire(String hotel) {
        if (hotel.equals("B")) {
            chambres.add(new Chambre("PT-101", "Hotel du Port", "Montpellier", 4, 2, new BigDecimal("110.00")));
            chambres.add(new Chambre("PT-102", "Hotel du Port", "Montpellier", 3, 4, new BigDecimal("95.00")));
            chambres.add(new Chambre("PT-201", "Hotel du Port", "Sete", 3, 2, new BigDecimal("70.00")));
        } else {
            chambres.add(new Chambre("CH-101", "Hotel des Arenes", "Montpellier", 3, 2, new BigDecimal("89.00")));
            chambres.add(new Chambre("CH-102", "Hotel des Arenes", "Montpellier", 3, 3, new BigDecimal("124.50")));
            chambres.add(new Chambre("CH-201", "Hotel des Arenes", "Montpellier", 4, 2, new BigDecimal("150.00")));
            chambres.add(new Chambre("CH-301", "Hotel des Arenes", "Sete", 2, 2, new BigDecimal("65.00")));
        }
    }

    @Override
    public List<Chambre> toutes() {
        return new ArrayList<>(chambres);
    }
}