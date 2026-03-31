package functional_interface;

import java.util.Scanner;
import java.util.function.Predicate;

public class TemperatureAlertSystem {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double temperature=sc.nextDouble();
		final double THRESHOLD=45;
		Predicate<Double> isCritical=t->t>THRESHOLD;
		if(isCritical.test(temperature)) {
			System.out.println("Temperature is critical, "+temperature+" degree celcius");
		}else {
			System.out.println("Temperature is not critical "+temperature+" degree celcius");
		}
		sc.close();
	}
}

