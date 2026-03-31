package functional_interface.multi_vehicle_rental_system;

public class Main {

	public static void main(String[] args) {
		Car car=new Car();
		car.rent(true);
		car.returnVehicle();
		
		Bike bike=new Bike();
		bike.rent(true);
		bike.returnVehicle();
		
		Bus bus=new Bus();
		bus.rent(true);
		bus.returnVehicle();
	}

}
