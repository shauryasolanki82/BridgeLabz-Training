package functional_interface.smart_device_control;

public class Main {

	public static void main(String[] args) {
		Lights lights=new Lights();
		lights.turnOn();
		lights.turnOff();
		
		AC ac=new AC();
		ac.turnOn();
		ac.turnOff();
		
		TV tv=new TV();
		tv.turnOn();
		tv.turnOff();
	}

}
