package scenario_based.vehicle_rental;

public abstract class Vehicle implements IRentable {
    protected String vehicleId;
    protected String brand;
    protected String model;
    protected double baseRatePerDay;
    protected boolean isAvailable;

    public Vehicle(String vehicleId, String brand, String model, double baseRatePerDay) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.baseRatePerDay = baseRatePerDay;
        this.isAvailable = true;
    }

    public String getVehicleId() { return vehicleId; }
    public boolean isAvailable() { return isAvailable; }

    public void rentVehicle() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(brand + " " + model + " has been rented.");
        } else {
            System.out.println("Vehicle is already rented out.");
        }
    }

    public void returnVehicle() {
        isAvailable = true;
        System.out.println(brand + " " + model + " has been returned.");
    }

    @Override
    public String toString() {
        return "[" + vehicleId + "] " + brand + " " + model + " ($" + baseRatePerDay + "/day)";
    }
}
