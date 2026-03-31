package functional_interface.multi_vehicle_rental_system;

public class Bus implements Rental{
	@Override
	public void rent(boolean availability) {
		if(availability) {
			System.out.println("Bus is rented to you.");
		}else {
			System.out.println("Bus is not available.");
		}
	}
	
	@Override
	public void returnVehicle() {
		System.out.println("Bus is returned.");
	}
}
