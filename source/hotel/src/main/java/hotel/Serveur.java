package hotel;

import hotel.depot.ChambreDepotMemoire;
import hotel.service.ServiceHotel;
import jakarta.xml.ws.Endpoint;

public class Serveur {

    public static void main(String[] args) {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : 8082; //utilser agument pour otel 
        String hotel = args.length > 1 ? args[1] : "A";
        String adresse = "http://localhost:" + port + "/hotel";
        ServiceHotel service = new ServiceHotel(new ChambreDepotMemoire(hotel));
        Endpoint.publish(adresse, new HotelPortImpl(service));
        System.out.println("Hotel " + hotel + " publie : " + adresse);
        System.out.println("Contrat WSDL    : " + adresse + "?wsdl");
        System.out.println("Ctrl+C pour arreter.");
    }
}