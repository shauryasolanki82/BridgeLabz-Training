package regex;

import java.util.Scanner;

public class ReplaceSpaces {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter sentence may contain spaces");
		String s = sc.nextLine();
		String replacedString = s.replaceAll("\\s+", " ");
		System.out.println(replacedString);
		
		sc.close();
	}

}
