package functional_interface.smart_device_control;

public class AC implements SmartDeviceControl {
	@Override
	public void turnOff() {
		System.out.println("AC is turned Off.");
	}
	
	@Override
	public void turnOn() {
		System.out.println("AC is turned On.");
	}
}
