
import java.util.Scanner;

public class Palindrome {
	
	public static String reverse(String text) {
		StringBuilder sb = new StringBuilder();
		for(int i=text.length()-1; i >= 0; i--) {
			sb = sb.append(text.charAt(i));
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String text = input.nextLine().trim();
		String reversedString = reverse(text.toLowerCase());
		if(text.toLowerCase().equals(reversedString)) {
			System.out.println("Palindrome");
		}else {
			System.out.println("Not Palindrome");
		}
		input.close();
	}
}
