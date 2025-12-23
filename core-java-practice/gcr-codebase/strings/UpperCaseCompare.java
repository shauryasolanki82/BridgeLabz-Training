import java.util.Scanner;

public class UpperCaseCompare {

    // This method converts text to uppercase using ASCII logic
    static String convertToUpperCase(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // check if character is lowercase
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32);
            }

            result = result + ch;
        }
        return result;
    }

    // This method compares two strings using charAt()
    static boolean compareStrings(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter complete text: ");
        String input = scanner.nextLine();

        // built-in method
        String builtInUpper = input.toUpperCase();

        // user-defined method
        String manualUpper = convertToUpperCase(input);

        boolean result = compareStrings(builtInUpper, manualUpper);

        System.out.println("Uppercase using built-in method: " + builtInUpper);
        System.out.println("Uppercase using user-defined method: " + manualUpper);
        System.out.println("Are both results same? " + result);

        scanner.close();
    }
}