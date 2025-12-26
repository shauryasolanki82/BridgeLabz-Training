package methods;
import java.util.*;

public class NumberChecker2 {
	
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

    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }
    
    public static int sumOfSquares(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += (int) Math.pow(digit, 2); 
        }
        return sum;
    }

    public static boolean harshadNumber(int originalNum, int sumOfDigits) {
        // Prevent division by zero
        if (sumOfDigits == 0) return false; 
        return originalNum % sumOfDigits == 0;
    }

    public static int[][] digitFrequency(int[] digits) {
        int[] counts = new int[10];
        for (int digit : digits) {
            counts[digit]++;
        }
        int distinctCount = 0;
        for (int count : counts) {
            if (count > 0) distinctCount++;
        }
        int[][] frequencyMap = new int[distinctCount][2];
        int rowIndex = 0;
        for (int i = 0; i < 10; i++) {
            if (counts[i] > 0) {
                frequencyMap[rowIndex][0] = i;
                frequencyMap[rowIndex][1] = counts[i];
                rowIndex++;
            }
        }
        return frequencyMap;
    }

    public static void displayFrequency(int[][] data) {
        System.out.printf("%-10s %-10s%n", "Digit", "Frequency");
        System.out.println("--------------------");
        for (int[] row : data) {
            System.out.printf("%-10d %-10d%n", row[0], row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int count = digitCount(number);
        System.out.println("Count of digits: " + count);
        
        int[] digits = digitsArray(number);
        System.out.println("Digits Array: " + Arrays.toString(digits));
        
        int sum = sumOfDigits(digits);
        System.out.println("Sum of digits: " + sum);
        
        int sumSquares = sumOfSquares(digits);
        System.out.println("Sum of squares: " + sumSquares);
        
        boolean isHarshad = harshadNumber(number, sum);
        System.out.println("Is Harshad Number? " + (isHarshad ? "Yes" : "No"));
        
        System.out.println("\nDigit Frequency:");
        int[][] frequencyData = digitFrequency(digits);
        displayFrequency(frequencyData);
        input.close();
    }
}