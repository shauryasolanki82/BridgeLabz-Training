
import java.util.*;

public class RemoveDuplicates {
	
	public static String removeDuplicates(String text) {
		HashMap<Character, Integer> freq = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		for(char c : text.toCharArray()) {
			if(c == ' ') {
				continue;
			}
			if(freq.containsKey(c)) {
				continue;
			}else {
				freq.put(c, 1);
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String text = input.nextLine().trim();
		String result = removeDuplicates(text.toLowerCase());
		System.out.println(result);
		input.close();
	}
}
