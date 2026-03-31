
import java.util.Scanner;

public class Anagram {

	public static boolean isAnagram(String text1, String text2) {
		if (text1.length() != text2.length()) {
			return false;
		}
		int[] freq1 = new int[256];
		int[] freq2 = new int[256];
		for (int i = 0; i < text1.length(); i++) {
			freq1[text1.charAt(i)]++;
			freq2[text2.charAt(i)]++;
		}
		for (int i = 0; i < 256; i++) {
			if (freq1[i] != freq2[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the first text: ");
		String str1 = input.nextLine();
		System.out.print("Enter the second text: ");
		String str2 = input.nextLine();
		if (isAnagram(str1, str2)) {
			System.out.println(str1 + " and " + str2 + " are anagrams.");
		} else {
			System.out.println(str1 + " and " + str2 + " are NOT anagrams.");
		}
		input.close();
	}
}
