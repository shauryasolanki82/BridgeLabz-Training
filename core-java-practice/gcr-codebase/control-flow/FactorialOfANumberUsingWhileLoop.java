import java.util.Scanner;

public class FactorialOfANumberUsingWhileLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int factorial = 1;
        int i = 1;

        while (i <= number) {
            factorial *= i;
            i++;
        }

        System.out.println("The factorial of " + number + " is: " + factorial);
        scanner.close();
    }
}
