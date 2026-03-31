
import java.util.Scanner;

public class Factors{
	static int[] findFactors(int num) {
		int count = 0;
		for(int i=1; i<num; i++) {
			if(num%i == 0) {
				count++;
			}
		}
		int[] temp = new int[count];
		int j = 0;
		for(int i=1; i<num; i++) {
			if(num%i == 0) {
				temp[j++] = i;
			}
		}
		return temp;
	}
	
	static int sumFactors(int[] factors) {
		int sum = 0;
		for(int i:factors) {
			sum += i;
		}
		return sum;
	}
	
	static int multiplyFactors(int[] factors) {
		int product = 1;
		for(int i:factors) {
			product *= i;
		}
		return product;
	}
	
	static double sumOfSquareOfFactors(int[] factors) {
		double sum = 0;
		for(int i:factors) {
			sum = sum + Math.pow(i, 2);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		int[] factors = findFactors(number);
		int sum = sumFactors(factors);
		int product = multiplyFactors(factors);
		double sumSquare = sumOfSquareOfFactors(factors);
		System.out.print("Factors Of "+number+" are: ");
		for(int i:factors) {
			System.out.print(i+" ");
		}
		System.out.println("\nSum Of Factors : "+sum);
		System.out.println("Product Of Factors : "+product);
		System.out.println("Sum Of Square Of Factors : "+sumSquare);
		input.close();
	}
}