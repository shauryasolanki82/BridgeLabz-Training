import java.util.Scanner;
public class CompareTwoStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string1 = scanner.next();
        String string2 = scanner.next();
        //comparing strings using custom function and built-in method
        boolean areEqualUsingCharAt = compareStrings(string1, string2);
        boolean areEqualUsingEquals = string1.equals(string2);
        //printing results
        if (areEqualUsingCharAt == areEqualUsingEquals) {
            System.out.println("Both methods give the same result.");
        } else {
            System.out.println("The methods give different results.");
        }

        scanner.close();
    }
    //function to compare two strings character by character
    public static boolean compareStrings(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }
        for (int i = 0; i < string1.length(); i++) {
            if (string1.charAt(i) != string2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
