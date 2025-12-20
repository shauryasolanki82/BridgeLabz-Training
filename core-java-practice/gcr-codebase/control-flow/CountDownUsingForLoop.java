import java.util.Scanner;

public class CountDownUsingForLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt(); // Example input number

        for (int i = number; i >= 0; i--) {
            System.out.println(i);
        }
        scanner.close();
    }
}
