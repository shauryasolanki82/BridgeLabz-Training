package functional_interface;

import java.util.Scanner;
import java.util.function.Function;

public class StringLengthChecker {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		final int CHARACTER_LIMIT=15;
		String message=sc.nextLine();
		Function<String,Integer> len=m->m.length();
		if(len.apply(message)>CHARACTER_LIMIT) {
			System.out.println("Message exceeded the character limit.");
		}else {
			System.out.println("Message is within the character limit.");
		}
		sc.close();
	}

}
