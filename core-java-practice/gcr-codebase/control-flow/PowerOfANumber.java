import java.util.Scanner;
public class PowerOfANumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int base = scanner.nextInt();
        int exponent = scanner.nextInt();
        int result = 1;

        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }

        System.out.println(result);
        scanner.close();
    }
}
