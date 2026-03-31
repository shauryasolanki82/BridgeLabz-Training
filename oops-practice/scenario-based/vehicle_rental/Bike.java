package scenario_based.vehicle_rental;

public class Bike extends Vehicle {
    public Bike(String vehicleId, String brand, String model) {
        super(vehicleId, brand, model, 15.0); 
    }

    @Override
    public double calculateRent(int days) {
        return baseRatePerDay * days;
    }
}
