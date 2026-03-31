import java.util.Scanner;

public class CountDownUsingWhileLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt(); // Example input number

        while (number >= 0) {
            System.out.println(number);
            number--;
        }
        scanner.close();
    }
}
