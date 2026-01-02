
import java.util.*;

public class SentenceFormatter {
	
	public static String addSpaceAfterPunctuation(String text) {
		String result = text.replaceAll("\\p{Punct}", "$0 ");
		return result;
	}
	
	public static String nextCapitalLetter(String text) {
		StringBuilder sb = new StringBuilder();
		boolean capitalizeNext = true;
		for(int i=0; i<text.length(); i++) {
			char curr = text.charAt(i);
			if (Character.isWhitespace(curr)) {
                sb.append(curr);
                capitalizeNext = true; 
            } else if (capitalizeNext) {
                sb.append(Character.toUpperCase(curr));
                capitalizeNext = false; 
            } else {
                sb.append(curr);
            }
		}
		return sb.toString();
	}
	
	public static String trimExtraSpaces(String text) {
		String result = text.replaceAll("\\s+", " ");
		return result;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String text = input.nextLine().trim();
		text = trimExtraSpaces(text);
		text = addSpaceAfterPunctuation(text);
		text = nextCapitalLetter(text);
		System.out.println(text);
		input.close();
	}
}
