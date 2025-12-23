import java.util.Scanner;

public class LeadingAndTraillingSpace {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string with leading and trailing spaces: ");
        String input = scanner.nextLine();

        // Custom trim logic
        int[] indexes = findTrimIndexes(input);
        String customTrimmed =
                createSubstring(input, indexes[0], indexes[1]);

        // Built-in trim
        String builtInTrimmed = input.trim();

        // Compare results
        boolean isSame = compareStrings(customTrimmed, builtInTrimmed);

        System.out.println("\nCustom Trimmed String : \"" + customTrimmed + "\"");
        System.out.println("Built-in Trim String : \"" + builtInTrimmed + "\"");
        System.out.println("Are both strings equal? " + isSame);

        scanner.close();
    }

    public static int[] findTrimIndexes(String text) {

        int start = 0;
        int end = text.length() - 1;

        // Trim leading spaces
        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }

        // Trim trailing spaces
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }

        return new int[] { start, end };
    }

    // Method to create substring using charAt()
    public static String createSubstring(String text, int start, int end) {

        String result = "";

        for (int i = start; i <= end; i++) {
            result = result + text.charAt(i);
        }

        return result;
    }

    // Method to compare two strings using charAt()
    public static boolean compareStrings(String str1, String str2) {

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


    
}
//Leading and trailing