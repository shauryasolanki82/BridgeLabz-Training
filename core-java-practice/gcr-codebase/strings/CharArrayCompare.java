import java.util.Scanner;

public class CharArrayCompare {

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Take user input
        String text = scanner.next();

        // Get characters using user-defined method
        char[] userDefinedArray = getCharsUsingCharAt(text);

        // Get characters using built-in method
        char[] builtInArray = text.toCharArray();

        // Compare both arrays
        boolean result = compareCharArrays(userDefinedArray, builtInArray);

        System.out.print("Characters using user-defined method: ");
        for (char c : userDefinedArray) {
            System.out.print(c + " ");
        }

        System.out.println();

        System.out.print("Characters using toCharArray(): ");
        for (char c : builtInArray) {
            System.out.print(c + " ");
        }

        System.out.println();
        System.out.println("Are both character arrays equal? " + result);

        scanner.close();
    }

    // Method to return characters of a string without using toCharArray()
    public static char[] getCharsUsingCharAt(String text) {
        char[] characters = new char[text.length()];

        for (int i = 0; i < text.length(); i++) {
            characters[i] = text.charAt(i);
        }

        return characters;
    }

    // Method to compare two char arrays
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {

        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

}