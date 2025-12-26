package methods;
import java.util.Scanner;

public class Chocolates{
	public static int[] findChocolatesAndChildren(int number, int divisor) {
		int temp[] = new int[2];
		temp[0] = number/divisor;
		temp[1] = number%divisor;
		return temp;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numberOfChocolates = input.nextInt();
		int numberOfChildren = input.nextInt();
		int[] arr = findChocolatesAndChildren(numberOfChocolates, numberOfChildren);
		System.out.println("Number Of Remaining Chocolates: "+arr[0]);
		System.out.println("Number Of Each Child gets: "+arr[1]);
		input.close();
	}
}