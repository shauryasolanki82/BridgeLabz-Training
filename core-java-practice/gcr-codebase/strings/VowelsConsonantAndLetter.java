import java.util.Scanner;
public class VowelsConsonantAndLetter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = scanner.nextLine();

        int[] counts = findVowelsAndConsonants(str);

        System.out.println("Number of Vowels: " + counts[0]);
        System.out.println("Number of Consonants: " + counts[1]);

        scanner.close();
    }

    
    public static String checkCharacter(char ch) {

        // Convert uppercase to lowercase using ASCII values
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        // Check if character is a letter
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || 
                ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }

        return "Not a Letter";
    }
    public static int[] findVowelsAndConsonants(String text) {

        int vowelCount = 0;
        int consonantCount = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            String result = checkCharacter(ch);

            if (result.equals("Vowel")) {
                vowelCount++;
            } else if (result.equals("Consonant")) {
                consonantCount++;
            }
        }

        return new int[] { vowelCount, consonantCount };
    }

    
}