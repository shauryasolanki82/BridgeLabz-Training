package functional_interface.multi_vehicle_rental_system;

public class Car implements Rental{
	@Override
	public void rent(boolean availability) {
		if(availability) {
			System.out.println("Car is rented to you.");
		}else {
			System.out.println("Car is not available.");
		}
	}
	
	@Override
	public void returnVehicle() {
		System.out.println("Car is returned.");
	}
}
