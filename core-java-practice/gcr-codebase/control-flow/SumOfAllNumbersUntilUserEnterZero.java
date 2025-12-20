import java.util.Scanner;

public class SumOfAllNumbersUntilUserEnterZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        while (true) {
            int number = scanner.nextInt();
            if (number == 0) {
                break;
            }
            sum += number;
        }
        System.out.println("The sum of all numbers entered is: " + sum);
        scanner.close();
    }
}
