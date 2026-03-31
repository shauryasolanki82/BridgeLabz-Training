import java.util.Scanner;
class PalindromeChecker {
    String text;
    PalindromeChecker(String text) {
        this.text = text;
    }
    boolean isPalindrome() {
        String cleanedText = text.replaceAll("\\s+", "").toLowerCase();
        String reverse = "";
        for (int i = cleanedText.length() - 1; i >= 0; i--) {
            reverse = reverse + cleanedText.charAt(i);
        }

        return cleanedText.equals(reverse);
    }

    void displayResult() {
        if (isPalindrome()) {
            System.out.println(text + " is palindrome");
        } else {
            System.out.println(text + " is not Palindrome");
        }
    }
}
public class PalindromeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        PalindromeChecker pc = new PalindromeChecker(input);
        pc.displayResult();
        sc.close();
    }
}

