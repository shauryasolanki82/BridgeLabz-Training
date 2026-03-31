import java.util.Scanner;

class Solution {
    public boolean isPalindrome(int x) {
        int rem = 0;
        int r = 0;
        int t = x;

        while (x > 0) {
            r = x % 10;
            rem = rem * 10 + r;
            x = x / 10;
        }

        if (t == rem) {
            return true;
        } else {
            return false;
        }
    }
}

public class PalindromeNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take input from user
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        Solution sol = new Solution();
        boolean result = sol.isPalindrome(num);

        // Print result
        if (result) {
            System.out.println(num + " is a Palindrome");
        } else {
            System.out.println(num + " is NOT a Palindrome");
        }

        sc.close();
    }
}
