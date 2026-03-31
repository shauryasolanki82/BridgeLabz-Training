package scenario_based.vehicle_rental;

public class Main {
    public static void main(String[] args) {
        Rental agency = new Rental();
        agency.addVehicle(new Bike("B001", "Yamaha", "R15"));
        agency.addVehicle(new Car("C001", "Toyota", "Corolla"));
        agency.addVehicle(new Truck("T001", "Volvo", "FH16"));
        Customer customer = new Customer("Alice", "DL-12345");
        agency.showAvailableVehicles();
        System.out.println("Rental Process");
        agency.rentVehicle("C001", customer, 3);
        System.out.println("Renting Truck");
        agency.rentVehicle("T001", customer, 2);
        System.out.println("Failure Scenario");
        agency.rentVehicle("C001", new Customer("Bob", "DL-999"), 1);
        System.out.println("Return Process");
        agency.returnVehicle("C001");
        agency.showAvailableVehicles();
    }
}
