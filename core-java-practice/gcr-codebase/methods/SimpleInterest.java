package methods;
import java.util.*;

public class SimpleInterest{
	public static void simpleInterest(int p, int r, int t) {
		float si = (float)(p*r*t)/100;
		System.out.println("The Simple Interest is "+si+" for Principal "+p+", Rate of Interest "+r+" and Time "+t);
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int p = input.nextInt();
		int r = input.nextInt();
		int t = input.nextInt();
		simpleInterest(p, r, t);
		input.close();
	}
}