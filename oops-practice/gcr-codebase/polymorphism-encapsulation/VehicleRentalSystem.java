
import java.util.*;

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    abstract double calculateRentalCost(int days);

    public String getVehicleNumber() { 
    	return vehicleNumber;
    }
    public String getType() { 
    	return type;
    }
    public double getRentalRate() { 
    	return rentalRate;
    }
    public void setRentalRate(double rentalRate) { 
    	this.rentalRate = rentalRate;
    }

    public void displayBasicInfo() {
        System.out.println("Vehicle No: " + vehicleNumber + " | Type: " + type + " | Rate/Day: $" + rentalRate);
    }
}

class Car extends Vehicle implements Insurable {
    
	private String policyNumber;

    Car(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.policyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 25.00;
    }

    @Override
    public String getInsuranceDetails() {
        return "Standard Auto Policy (Policy #" + maskPolicyNumber() + ")";
    }

    private String maskPolicyNumber() {
        return "XXXX" + policyNumber.substring(policyNumber.length() - 4);
    }
}

class Bike extends Vehicle implements Insurable {
    
    private String policyNumber;

    Bike(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Bike", rentalRate);
        this.policyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        double cost = getRentalRate() * days;
        if (days > 7) {
            cost *= 0.90;
        }
        return cost;
    }

    @Override
    public double calculateInsurance() {
        return 10.00;
    }

    @Override
    public String getInsuranceDetails() {
        return "Two-Wheeler Protection (Policy #" + "XXXX" + policyNumber.substring(policyNumber.length() - 4) + ")";
    }
}

class Truck extends Vehicle implements Insurable {
    
    private String policyNumber;

    Truck(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.policyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return (getRentalRate() * days) + 50.00;
    }

    @Override
    public double calculateInsurance() {
        return 60.00;
    }

    @Override
    public String getInsuranceDetails() {
        return "Heavy Commercial Policy (Policy #" + "XXXX" + policyNumber.substring(policyNumber.length() - 4) + ")";
    }
}

public class VehicleRentalSystem {

    public static void main(String[] args) {
        int rentalDays = 5;
        Vehicle car = new Car("UP80-CA-1234", 60.0, "POL-987654321");
        Vehicle bike = new Bike("UP80-BK-5678", 20.0, "POL-123456789");
        Vehicle truck = new Truck("UP80-TR-9012", 150.0, "POL-456123789");
        List<Vehicle> fleet = new ArrayList<>();
        fleet.add(car);
        fleet.add(bike);
        fleet.add(truck);
        System.out.println("RENTAL QUOTE (Duration: " + rentalDays + " Days)");
        double totalRevenue = 0;
        for (Vehicle v : fleet) {
            v.displayBasicInfo();
            double rentalCost = v.calculateRentalCost(rentalDays);
            double insuranceCost = 0;
            if (v instanceof Insurable) {
                Insurable ins = (Insurable) v;
                insuranceCost = ins.calculateInsurance();
                System.out.println("   Insurance: $" + insuranceCost + " | " + ins.getInsuranceDetails());
            }
            double totalCost = rentalCost + insuranceCost;
            totalRevenue += totalCost;
            System.out.println("   Rental Cost: $" + rentalCost);
            System.out.println("   Total for Vehicle: $" + totalCost);
        }

        System.out.println("Total Estimated Revenue: $" + totalRevenue);
    }
}
