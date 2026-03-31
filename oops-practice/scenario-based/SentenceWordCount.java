
import java.util.*;

public class SentenceWordCount {
	
	static String trimExtraSpaces(String text) {
		String result = text.replaceAll("\\s+", " ");
		return result;
	}
	
	static int countNumberOfWords(String str) {
		String[] temp = str.split(" ");
		return temp.length;
	}
	
	static void findLongestWord(String str) {
		String[] temp = str.split(" ");
		String longest = "";
		for(String i: temp) {
			if(i.length() > longest.length()) {
				longest = i;
			}
		}
		System.out.println("Longest Word in Paragraph is: "+longest);
	}

	public static void main(String[] args) {
		Scanner input =  new Scanner(System.in);
		String text = input.nextLine().trim();
		text = trimExtraSpaces(text);
		int countWords = countNumberOfWords(text);
		System.out.println(countWords);
		findLongestWord(text);
		System.out.print("Enter Word to replace: ");
		String oldWord = input.next();
		System.out.print("Enter New Word: ");
		String newWord = input.next();
		text = text.replaceAll("\\b"+oldWord+"\\b", newWord);
		System.out.println(text);
		input.close();
	}
}
