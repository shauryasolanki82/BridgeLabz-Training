import java.util.Scanner;

public class FactorsOfANumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        if (number > 0) {
            System.out.println("Factors of " + number + " are:");
            for (int i = 1; i < number; i++) {
                if (number % i == 0) {
                    System.out.println(i);
                }
            }
        } else {
            System.out.println("Please enter a positive integer.");
        }
        scanner.close();
    }
}
