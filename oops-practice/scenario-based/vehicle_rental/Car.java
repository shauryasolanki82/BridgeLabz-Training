package scenario_based.vehicle_rental;

public class Car extends Vehicle {
    public Car(String vehicleId, String brand, String model) {
        super(vehicleId, brand, model, 50.0); 
    }

    @Override
    public double calculateRent(int days) {
        return baseRatePerDay * days;
    }
}
