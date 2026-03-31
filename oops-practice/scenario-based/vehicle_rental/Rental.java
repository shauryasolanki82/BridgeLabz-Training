package scenario_based.vehicle_rental;
import java.util.*;

public class Rental {
    private List<Vehicle> fleet;

    public Rental() {
        this.fleet = new ArrayList<>();
    }

    public void addVehicle(Vehicle v) {
        fleet.add(v);
    }
    
    public void showAvailableVehicles() {
        System.out.println("Available Vehicles");
        for (Vehicle v : fleet) {
            if (v.isAvailable()) {
                System.out.println(v);
            }
        }
    }

    public void rentVehicle(String vehicleId, Customer customer, int days) {
        for (Vehicle v : fleet) {
            if (v.getVehicleId().equals(vehicleId)) {
                if (v.isAvailable()) {
                    v.rentVehicle();
                    double cost = v.calculateRent(days);
                    System.out.println("Invoice for " + customer.getName() + ": $" + cost);
                } else {
                    System.out.println("Sorry, that vehicle is unavailable.");
                }
                return;
            }
        }
        System.out.println("Vehicle ID not found.");
    }
    
    public void returnVehicle(String vehicleId) {
        for (Vehicle v : fleet) {
            if (v.getVehicleId().equals(vehicleId)) {
                v.returnVehicle();
                return;
            }
        }
    }
}
