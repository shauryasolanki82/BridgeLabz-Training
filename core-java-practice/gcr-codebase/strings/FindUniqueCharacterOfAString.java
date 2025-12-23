import java.util.Scanner;

public class FindUniqueCharacterOfAString {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        char[] uniqueChars = findUniqueCharacters(input);

        System.out.print("Unique characters: ");
        for (char c : uniqueChars) {
            System.out.print(c + " ");
        }

        scanner.close();
    }

    // Method to find length of string without using length()
    public static int findLength(String text) {
        int count = 0;
        try {
            while(true) {
                text.charAt(count);
                count++;
            }
        } catch(Exception e) {
        }
        return count;
    }

    // Method to find unique characters using charAt()
    public static char[] findUniqueCharacters(String text) {

        int length = findLength(text);
        char[] temp = new char[length];
        int uniqueCount = 0;

        for (int i = 0; i < length; i++) {
            char currentChar = text.charAt(i);
            boolean isUnique = true;

            // Check if currentChar appeared prior 
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == currentChar) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                temp[uniqueCount] = currentChar;
                uniqueCount++;
            }
        }

        // Create new array to store exact unique characters
        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = temp[i];
        }

        return result;
    }

}