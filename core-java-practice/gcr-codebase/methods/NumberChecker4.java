
import java.util.Scanner;

public class NumberChecker4 {

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNeonNumber(int num) {
        int square = num * num;
        int sumOfSquareDigits = 0;
        while (square > 0) {
            sumOfSquareDigits += square % 10;
            square /= 10;
        }
        return sumOfSquareDigits == num;
    }

    public static boolean isSpyNumber(int num) {
        int sum = 0;
        int product = 1;
        int temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }
        return sum == product;
    }

    public static boolean isAutomorphicNumber(int num) {
        long square = (long) num * num;
        String numStr = String.valueOf(num);
        long divisor = (long) Math.pow(10, numStr.length());
        return (square % divisor) == num;
    }

    public static boolean isBuzzNumber(int num) {
        return (num % 7 == 0) || (num % 10 == 7);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Number: ");
        int number = input.nextInt();
        System.out.println("Is Prime Number? " + (isPrime(number) ? "Yes" : "No"));
        System.out.println("Is Neon Number? " + (isNeonNumber(number) ? "Yes" : "No"));
        System.out.println("Is Spy Number? " + (isSpyNumber(number) ? "Yes" : "No"));
        System.out.println("Is Automorphic Number? " + (isAutomorphicNumber(number) ? "Yes" : "No"));
        System.out.println("Is Buzz Number? " + (isBuzzNumber(number) ? "Yes" : "No"));
        input.close();
    }
}