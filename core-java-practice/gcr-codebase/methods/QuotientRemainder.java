
import java.util.Scanner;

public class QuotientRemainder{
	public static int[] findRemainderAndQuotient(int number, int divisor) {
		int[] temp = new int[2];
		temp[0] = number/divisor;
		temp[1] = number%divisor;
		return temp;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		int divisor = input.nextInt();
		int[] arr = findRemainderAndQuotient(number, divisor);
		System.out.println("Quotient: "+arr[0]);
		System.out.println("Remainder: "+arr[1]);
		input.close();
	}
}