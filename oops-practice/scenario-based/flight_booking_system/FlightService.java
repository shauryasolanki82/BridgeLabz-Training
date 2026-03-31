package scenario_based.flight_booking_system;
import java.util.*;

public class FlightService {
    private Flight[] availableFlights;
    private List<Flight> myBookings;

    public FlightService() {
        this.myBookings = new ArrayList<>();
        initializeFlights();
    }

    private void initializeFlights() {
        availableFlights = new Flight[5];
        availableFlights[0] = new Flight(101, "Delta", "New York", "London", 450.00);
        availableFlights[1] = new Flight(102, "Emirates", "Dubai", "New York", 850.00);
        availableFlights[2] = new Flight(103, "British Air", "London", "Paris", 120.00);
        availableFlights[3] = new Flight(104, "Lufthansa", "Berlin", "Dubai", 300.00);
        availableFlights[4] = new Flight(105, "Air India", "Mumbai", "London", 500.00);
    }

    public void searchFlights(String source, String dest) {
        System.out.println("Search Results for " + source + " to " + dest);
        boolean found = false;

        for (Flight f : availableFlights) {
            if (f.getSource().equalsIgnoreCase(source) && f.getDestination().equalsIgnoreCase(dest)) {
                System.out.println(f);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No flights found.");
        }
    }

    public void bookFlight(int flightId) {
        boolean found = false;
        for (Flight f : availableFlights) {
            if (f.getFlightId() == flightId) {
                myBookings.add(f);
                System.out.println("Success! Booked flight: " + f);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Invalid Flight ID.");
        }
    }

    public void displayBookings() {
        System.out.println("My Bookings");
        if (myBookings.isEmpty()) {
            System.out.println("No bookings yet.");
        } else {
            for (Flight f : myBookings) {
                System.out.println(f);
            }
        }
    }
}
