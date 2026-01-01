public class Vehicle {
	
	private static float registrationFee = 150.0f;
	private String ownerName;
	private String vehicleType;
	private final String registrationNumber;
	
	Vehicle(String ownerName, String vehicleType, String registrationNumber){
		this.ownerName = ownerName;
		this.vehicleType = vehicleType;
		this.registrationNumber = registrationNumber;
	}
	
	public void displayVehicleDetails() {
		if(this instanceof Vehicle) {
			System.out.println("Owner Name: "+ownerName);
			System.out.println("Vehicle Type: "+vehicleType);
			System.out.println("Registration Number: "+registrationNumber);
			System.out.printf("Registration Fee: $%.1f%n",registrationFee);
		}
	}
	
	public static void updateRegistrationFee(float newFee) {
		registrationFee = newFee;
	}

	public static void main(String[] args) {
		Vehicle car1 = new Vehicle("Honest raj", "Sedan", "ABC123");
		Vehicle car2 = new Vehicle("Price danish", "SUV", "XYZ789");
		car1.displayVehicleDetails();
		car2.displayVehicleDetails();
		Vehicle.updateRegistrationFee(200.0f);
		System.out.printf("Updated Registration Fee: $%.1f%n",Vehicle.registrationFee);
	}

}
