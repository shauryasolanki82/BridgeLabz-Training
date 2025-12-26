package methods;
import java.util.Scanner;

public class Number {
	public static void check(int num) {
		if (num==0){
            System.out.println("Zero");
        }else if (num>0){
            System.out.println("Positive");
        }else{
            System.out.println("Negative");
        }
	}
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        check(number);
        input.close();
    }
}
