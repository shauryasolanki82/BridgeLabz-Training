import java.util.Scanner;

public class LowerCaseCompare {

    // This method converts text to lowercase using ASCII logic
    static String convertToLowerCase(String text) {
        String result = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // check if character is uppercase
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
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
        String builtInLower = input.toLowerCase();

        // user-defined method
        String manualLower = convertToLowerCase(input);

        boolean result = compareStrings(builtInLower, manualLower);

        System.out.println("Lowercase using built-in method: " + builtInLower);
        System.out.println("Lowercase using user-defined method: " + manualLower);
        System.out.println("Are both results same? " + result);

        scanner.close();
    }
}