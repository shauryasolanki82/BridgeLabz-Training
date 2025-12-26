package methods;
import java.util.Scanner;

public class NumberChecker5 {
	
    public static int sumOfProperDivisors(int num) {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static boolean isPerfectNumber(int num) {
        if (num <= 1) return false;
        return sumOfProperDivisors(num) == num;
    }

    public static boolean isAbundantNumber(int num) {
        if (num <= 1) return false;
        return sumOfProperDivisors(num) > num;
    }

    public static boolean isDeficientNumber(int num) {
        if (num <= 1) return false;
        return sumOfProperDivisors(num) < num;
    }

    public static boolean isStrongNumber(int num) {
        int originalNum = num;
        int sumOfFactorials = 0;
        while (num > 0) {
            int digit = num % 10;
            sumOfFactorials += factorial(digit);
            num /= 10;
        }
        return sumOfFactorials == originalNum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Number: ");
        int number = input.nextInt();
        System.out.println("Is Perfect Number?   " + (isPerfectNumber(number) ? "Yes" : "No"));
        System.out.println("Is Abundant Number?  " + (isAbundantNumber(number) ? "Yes" : "No"));
        System.out.println("Is Deficient Number? " + (isDeficientNumber(number) ? "Yes" : "No"));
        System.out.println("Is Strong Number?    " + (isStrongNumber(number) ? "Yes" : "No"));
        input.close();
    }
}
