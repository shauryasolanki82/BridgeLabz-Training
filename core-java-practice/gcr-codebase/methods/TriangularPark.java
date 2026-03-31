
import java.util.Scanner;

public class TriangularPark{
	public static void atheleteRounds(int a, int b, int c){
		int perimeter = a+b+c;
		int rounds = 5000/perimeter;
		System.out.println("No. of Rounds: "+rounds);
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		atheleteRounds(a,b,c);
		input.close();
	}
}