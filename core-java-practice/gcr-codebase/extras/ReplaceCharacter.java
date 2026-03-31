
import java.util.Scanner;

public class ReplaceCharacter {
	
	public static String replace(String text, char oldChar, char newChar) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<text.length(); i++) {
			if(text.charAt(i) == oldChar) {
				sb.append(newChar);
			}else {
				sb.append(text.charAt(i));
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String text = input.nextLine().trim();
		char oldChar = input.next().charAt(0);
		char newChar = input.next().charAt(0);
		String result = replace(text, oldChar, newChar);
		System.out.println(result);
		input.close();
	}
}
