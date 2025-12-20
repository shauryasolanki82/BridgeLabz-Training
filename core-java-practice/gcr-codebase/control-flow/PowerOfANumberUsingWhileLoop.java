import java.util.Scanner;
public class PowerOfANumberUsingWhileLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int base = scanner.nextInt();
        int exponent = scanner.nextInt();
        int result = 1;
        int i = 1;

        while (i <= exponent) {
            result *= base;
            i++;
        }

        System.out.println(result);
        scanner.close();
    }
}