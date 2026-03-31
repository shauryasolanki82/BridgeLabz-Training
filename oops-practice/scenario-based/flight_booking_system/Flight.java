package scenario_based.flight_booking_system;

public class Flight {
    private int flightId;
    private String airline;
    private String source;
    private String destination;
    private double price;

    public Flight(int flightId, String airline, String source, String destination, double price) {
        this.flightId = flightId;
        this.airline = airline;
        this.source = source;
        this.destination = destination;
        this.price = price;
    }

    public int getFlightId() { return flightId; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }

    @Override
    public String toString() {
        return "ID: " + flightId + " | " + airline + " | " + source + " -> " + destination + " | $" + price;
    }
}
