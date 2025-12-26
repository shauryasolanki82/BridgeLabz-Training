package methods;
import java.util.*;

public class NumberChecker {
	
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

    public static boolean duckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit == 0) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean armstrongNumber(int originalNum, int[] digits) {
        int power = digits.length;
        int sum = 0;
        
        for (int digit : digits) {
            sum += Math.pow(digit, power);
        }
        
        return sum == originalNum;
    }

    public static void findLargestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int digit : digits) {
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest && digit != largest) {
                secondLargest = digit;
            }
        }
        System.out.println("Largest Digit: " + largest);
        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("Second Largest Digit Not found ");
        } else {
            System.out.println("Second Largest Digit: " + secondLargest);
        }
    }

    public static void findSmallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int digit : digits) {
            if (digit < smallest) {
                secondSmallest = smallest;
                smallest = digit;
            } else if (digit < secondSmallest && digit != smallest) {
                secondSmallest = digit;
            }
        }
        System.out.println("Smallest Digit: " + smallest);
        if (secondSmallest == Integer.MAX_VALUE) {
            System.out.println("Second Smallest Digit Not found");
        } else {
            System.out.println("Second Smallest Digit: " + secondSmallest);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Number: ");
        int number = input.nextInt();
        
        int count = digitCount(number);
        System.out.println("Count of digits: " + count);
        
        int[] digits = digitsArray(number);
        System.out.println("Digits Array: " + Arrays.toString(digits));
        
        boolean isDuck = duckNumber(digits);
        System.out.println("Is Duck Number? " + (isDuck ? "Yes" : "No"));
        
        boolean isArmstrong = armstrongNumber(number, digits);
        System.out.println("Is Armstrong Number? " + (isArmstrong ? "Yes" : "No"));
        
        findLargestAndSecondLargest(digits);
        
        findSmallestAndSecondSmallest(digits);
        input.close();
    }
}
