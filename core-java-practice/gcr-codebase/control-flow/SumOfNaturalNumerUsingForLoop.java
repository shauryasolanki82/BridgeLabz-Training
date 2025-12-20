import java.util.Scanner;

public class SumOfNaturalNumerUsingForLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number < 1) {
            System.out.println("The number " + number + " is not a natural number.");
        } else {
            int sum = 0;
            for (int i = 1; i <= number; i++) {
                sum += i;
            }
            if(sum == (number * (number + 1)) / 2) {
                System.out.println("True");
            }
            else {
                System.out.println("False");
            }
        }
        scanner.close();
    }
}