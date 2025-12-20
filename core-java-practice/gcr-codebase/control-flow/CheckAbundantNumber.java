import java.util.Scanner;
public class CheckAbundantNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int sum = 0;

        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        if (sum > number) {
            System.out.println(number + " is an Abundant number");
        } else {
            System.out.println(number + " is not an Abundant number");
        }
        scanner.close();
    }
}
