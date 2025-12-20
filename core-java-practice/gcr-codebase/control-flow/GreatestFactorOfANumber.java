import java.util.Scanner;
public class GreatestFactorOfANumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int greatestFactor = 1;

        for (int i = number - 1; i >= 1; i--) {
            if (number % i == 0) {
                greatestFactor = i;
                break;
            }
        }

        System.out.println("The greatest factor of " + number + " is: " + greatestFactor);
        scanner.close();
    }
}
