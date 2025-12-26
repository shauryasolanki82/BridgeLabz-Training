package methods;
import java.util.Scanner;

public class NaturalNumberSum{
	public static void sum(int n) {
		int sum = 0;
		for(int i=1; i<=n; i++) {
			sum += i;
		}
		System.out.println("Natural Number sum upto n: "+sum);
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		sum(n);
		input.close();
	}
}