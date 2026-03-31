
import java.util.Scanner;

public class VowelsAndConsonants {
	
	public static void countVowelsAndConsonants(String text) {
		int countVowels = 0;
		int countConsonants = 0;
		for(int i=0; i<text.length(); i++) {
			char curr = text.toLowerCase().charAt(i);
			if(curr == 'a' || curr == 'e' || curr == 'i' || curr == 'o' || curr == 'u') {
				countVowels = countVowels+1;
			}else {
				if(curr >= 'a' && curr <= 'z') {
				countConsonants = countConsonants+1;
				}
			}
		}
		System.out.println("No. of Vowels in the string is: "+countVowels);
		System.out.println("No. of Consonants in the string is: "+countConsonants);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String text = input.nextLine().trim();
		countVowelsAndConsonants(text);
		input.close();
	}
}
