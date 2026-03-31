
import java.util.Scanner;

public class ReverseString {
	
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
		System.out.println("String: "+text);
		String reversedString = reverse(text);
		System.out.println("Reversed String: "+reversedString);
		input.close();
	}
}
