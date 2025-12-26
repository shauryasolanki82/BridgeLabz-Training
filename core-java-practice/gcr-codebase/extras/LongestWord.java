
import java.util.Scanner;

public class LongestWord {
	
	public static String longestWord(String text) {
		String[] str = text.split(" ");
		int maxLength = str[0].length();
		String word = str[0];
		for(int i=1; i<str.length; i++) {
			if(maxLength < str[i].length()) {
				maxLength = str[i].length();
				word = str[i];
			}
		}
		return word;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String text = input.nextLine().trim();
		String word = longestWord(text);
		System.out.println(word);
		input.close();
	}
}
