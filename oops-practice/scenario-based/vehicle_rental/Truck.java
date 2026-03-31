package scenario_based.vehicle_rental;

public class Truck extends Vehicle {
    public Truck(String vehicleId, String brand, String model) {
        super(vehicleId, brand, model, 100.0); 
    }

    @Override
    public double calculateRent(int days) {
        double baseTotal = baseRatePerDay * days;
        return baseTotal + (baseTotal * 0.10);
    }
}
