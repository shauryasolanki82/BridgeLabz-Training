import java.util.Scanner;

public class VowelsAndConsonant {

    // Method to check whether a character is vowel, consonant, or not a letter
    public static String checkChar(char ch) {

        // Convert uppercase to lowercase using ASCII values
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        // Check if character is a letter
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }

        return "Not a Letter";
    }

    // Method to find vowels and consonants using charAt()
    // Returns array: index 0 → vowels count, index 1 → consonants count
    public static int[] findVowelsConsonants(String text) {
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.toCharArray().length; i++) {
            char ch = text.charAt(i);
            String result = checkChar(ch);

            if (result.equals("Vowel")) {
                vowels++;
            } else if (result.equals("Consonant")) {
                consonants++;
            }
        }

        return new int[]{vowels, consonants};
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String text = sc.nextLine();

        int[] count = findVowelsConsonants(text);

        System.out.println("Number of Vowels: " + count[0]);
        System.out.println("Number of Consonants: " + count[1]);

        sc.close();
    }
}
