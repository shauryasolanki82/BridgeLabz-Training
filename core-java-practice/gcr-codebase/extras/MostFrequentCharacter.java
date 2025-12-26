
import java.util.*;

public class MostFrequentCharacter {
	
	public static char frequentCharacter(String text) {
		HashMap<Character, Integer> freq = new HashMap<>();
		for(char c : text.toCharArray()) {
			if(c == ' ') {
				continue;
			}
			if(freq.containsKey(c)) {
				freq.put(c, freq.get(c)+1);
			}else {
				freq.put(c, 1);
			}
		}
		char mostfrequent = ' ';
		int max = 0;
		for(Map.Entry<Character, Integer> entry: freq.entrySet()) {
			if(max < entry.getValue()) {
				mostfrequent = entry.getKey();
				max = entry.getValue();
			}
		}
		return mostfrequent;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String text = input.nextLine().trim();
		char result = frequentCharacter(text.toLowerCase());
		System.out.println(result);
		input.close();
	}

}
