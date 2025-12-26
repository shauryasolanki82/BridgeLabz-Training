
import java.util.Scanner;

public class SubstringOccurences {
	
	public static int occurences(String text, String subString) {
		int j = 0;
		int count = 0;
		for(int i=0; i<text.length(); i++) {
			if(text.charAt(i) == subString.charAt(j)) {
				j++;
			}
			if(j == subString.length()) {
				count++;
				j = 0;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String text = input.nextLine().trim();
		String subString = input.next();
		int result = occurences(text, subString);
		System.out.println(result);
		input.close();
	}
}
