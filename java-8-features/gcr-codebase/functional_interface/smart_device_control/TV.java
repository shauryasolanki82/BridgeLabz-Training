package functional_interface.smart_device_control;

public class TV implements SmartDeviceControl {
	@Override
	public void turnOff() {
		System.out.println("TV is turned Off.");
	}
	
	@Override
	public void turnOn() {
		System.out.println("TV is turned On.");
	}
}
