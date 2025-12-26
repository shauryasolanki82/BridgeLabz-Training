package methods;
import java.util.*;

public class NumberChecker3 {

    public static int digitCount(int num) {
        if (num == 0) return 1;
        return String.valueOf(Math.abs(num)).length();
    }

    public static int[] digitsArray(int num) {
        int count = digitCount(num);
        int[] digits = new int[count];
        int temp = Math.abs(num);
        
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }
        return digits;
    }

    public static int[] reverseArray(int[] digits) {
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }

    public static boolean compareArrays(int[] arr1, int[] arr2) {
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

    public static boolean isPalindrome(int number) {
        int[] original = digitsArray(number);
        int[] reversed = reverseArray(original);
        return compareArrays(original, reversed);
    }

    public static boolean duckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int[] originalDigits = digitsArray(number);
        System.out.println("Original Array: " + Arrays.toString(originalDigits));

        int[] reversedDigits = reverseArray(originalDigits);
        System.out.println("Reversed Array: " + Arrays.toString(reversedDigits));
        
        boolean arraysEqual = compareArrays(originalDigits, reversedDigits);
        System.out.println("Arrays are Equal? " + (arraysEqual ? "Yes" : "No"));

        boolean isPalindrome = isPalindrome(number);
        System.out.println("Is Palindrome? " + (isPalindrome ? "Yes" : "No"));

        boolean isDuck = duckNumber(originalDigits);
        System.out.println("Is Duck Number? " + (isDuck ? "Yes" : "No"));
        input.close();
    }
}