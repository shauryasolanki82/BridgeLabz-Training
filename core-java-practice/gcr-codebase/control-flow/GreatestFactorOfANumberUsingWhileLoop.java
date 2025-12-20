
import java.util.Scanner;
public class GreatestFactorOfANumberUsingWhileLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int greatestFactor = 1;
        int i = 1;

        while (i <= number / 2) {
            if (number % i == 0) {
                greatestFactor = i;
            }
            i++;
        }

        System.out.println("The greatest factor of " + number + " is: " + greatestFactor);
        scanner.close();
    }
}
