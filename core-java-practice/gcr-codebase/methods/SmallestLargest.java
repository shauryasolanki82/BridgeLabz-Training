
import java.util.*;

public class SmallestLargest{
	public static int[] findSmallestAndLargest(int number1, int number2, int number3) {
		int[] temp = new int[2];
		temp[0] = Math.max(number1, Math.max(number2, number3));
		temp[1] = Math.min(number1, Math.min(number2, number3));
		return temp;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num1 = input.nextInt();
		int num2 = input.nextInt();
		int num3 = input.nextInt();
		int[] arr = findSmallestAndLargest(num1, num2, num3);
		System.out.println("Smallest Number: "+arr[1]);
		System.out.println("Largest Number: "+arr[0]);
		input.close();
	}
}
