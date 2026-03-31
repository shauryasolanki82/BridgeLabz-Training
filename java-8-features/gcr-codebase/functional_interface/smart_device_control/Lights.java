package functional_interface.smart_device_control;

public class Lights implements SmartDeviceControl {
	@Override
	public void turnOff() {
		System.out.println("Light is turned Off.");
	}
	
	@Override
	public void turnOn() {
		System.out.println("Light is turned On.");
	}
}
