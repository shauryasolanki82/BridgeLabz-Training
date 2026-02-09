package functional_interface.multi_vehicle_rental_system;

public interface Rental {
	void rent(boolean availability);
	void returnVehicle();
}
