import java.util.Scanner;
public class QuotientAndReminder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dividend = scanner.nextInt(); // Example dividend
        int divisor = scanner.nextInt();   // Example divisor

        int quotient = dividend / divisor;
        int remainder = dividend % divisor;

        System.out.println("The Quotient is: " + quotient);
        System.out.println("The Remainder is: " + remainder);
        scanner.close();
    }
}
