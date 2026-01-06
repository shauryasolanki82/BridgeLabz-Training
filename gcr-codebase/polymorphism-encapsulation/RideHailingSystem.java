
import java.util.*;

interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

abstract class Vehicles implements GPS {
    
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    
    private String currentLocation;

    Vehicles(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = "Garage (Waiting)";
    }

    public abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("ID: " + vehicleId + " | Driver: " + driverName);
        System.out.println("Rate: $" + ratePerKm + "/km");
    }

    @Override
    public String getCurrentLocation() {
        return this.currentLocation;
    }
    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
        System.out.println("   [GPS] Location updated to: " + newLocation);
    }
    
    public double getRatePerKm() { 
    	return ratePerKm;
    }
}

class Cars extends Vehicles {

    public Cars(String vehicleId, String driverName) {
        super(vehicleId, driverName, 2.00);
    }

    @Override
    public double calculateFare(double distance) {
        double baseFare = 5.00;
        return baseFare + (getRatePerKm() * distance);
    }
    @Override
    public void getVehicleDetails() {
        super.getVehicleDetails();
        System.out.println("Type: Premium Car (AC Enabled)");
    }
}

class Bikes extends Vehicles {

    Bikes(String vehicleId, String driverName) {
        super(vehicleId, driverName, 0.80);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
    
    @Override
    public void getVehicleDetails() {
        super.getVehicleDetails();
        System.out.println("Type: Motorbike (Fastest in traffic)");
    }
}

class Auto extends Vehicles {

    public Auto(String vehicleId, String driverName) {
        super(vehicleId, driverName, 1.20);
    }

    @Override
    public double calculateFare(double distance) {
        double baseFare = 2.00;
        return baseFare + (getRatePerKm() * distance);
    }
    @Override
    public void getVehicleDetails() {
        super.getVehicleDetails();
        System.out.println("Type: Auto Rickshaw");
    }
}

public class RideHailingSystem {

    public static void processTrip(Vehicles vehicle, double distance, String destination) {
        vehicle.getVehicleDetails();
        System.out.println("Start Point: " + vehicle.getCurrentLocation());
        vehicle.updateLocation(destination);
        double cost = vehicle.calculateFare(distance);
        System.out.println("Trip Distance: " + distance + " km");
        System.out.println("TOTAL FARE: $" + String.format("%.2f", cost));
    }

    public static void main(String[] args) {
        List<Vehicles> availableFleet = new ArrayList<>();
        availableFleet.add(new Cars("C-101", "Alice"));
        availableFleet.add(new Bikes("B-202", "Bob"));
        availableFleet.add(new Auto("A-303", "Charlie"));
        System.out.println("RIDE REQUEST: 10 KM TRIP");
        for (Vehicles v : availableFleet) {
            processTrip(v, 10.0, "Central Station");
        }
    }
}