package searching;
import java.util.*;

public class RemoveDuplicates {

	public static void main(String[] args) {
		String input = "programming";
		String result = removeDuplicates(input);
		System.out.println("Original String: " + input);
		System.out.println("String without duplicates: " + result);
	}

	public static String removeDuplicates(String str) {
		if (str == null || str.isEmpty()) {
			return str;
		}
		StringBuilder sb = new StringBuilder();
		Set<Character> seen = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			char currentChar = str.charAt(i);
			if (!seen.contains(currentChar)) {
				sb.append(currentChar);
				seen.add(currentChar);
			}
		}
		return sb.toString();
	}
}
