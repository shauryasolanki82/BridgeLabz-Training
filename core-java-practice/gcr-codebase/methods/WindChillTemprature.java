package methods;
import java.util.*;

public class WindChillTemprature{
	public static double calculateWindChill(double temp, double windSpeed) {
		double windChill = 35.74 + 0.6215 *temp + (0.4275*temp - 35.75) * Math.pow(windSpeed, 0.16);
		return windChill;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double temperature = input.nextInt();
		double windSpeed = input.nextDouble();
		double ans = calculateWindChill(temperature, windSpeed);
		System.out.println("Wind Chill Temperature :"+ans);	
		input.close();
	}
}