package methods;
import java.util.*;

public class TrigonometricFunctions{
	public static double[] calculateTrigonometricFunctions(double angle) {
		double[] temp = new double[3];
		double radians = Math.toRadians(angle);
		temp[0] = Math.sin(radians);
		temp[1] = Math.cos(radians);
		temp[2] = Math.tan(radians);
		return temp;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double angle = input.nextDouble();
		double[] arr = calculateTrigonometricFunctions(angle);
		System.out.printf("sine value: %.4f%n",arr[0]);
		System.out.printf("cosine value: %.4f%n",arr[1]);
		System.out.printf("tangent value: %.4f%n",arr[2]);
		input.close();
	}
}