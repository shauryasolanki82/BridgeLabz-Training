package functional_interface.multi_vehicle_rental_system;

public class Bike implements Rental {
	@Override
	public void rent(boolean availability) {
		if(availability) {
			System.out.println("Bike is rented to you.");
		}else {
			System.out.println("Bike is not available.");
		}
	}
	
	@Override
	public void returnVehicle() {
		System.out.println("Bike is returned.");
	}
}
