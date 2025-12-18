import java.util.Scanner;
public class BasicCalculator {
    public static void main(String[] args) {
        // Basic calculator operations can be implemented here
        Scanner scanner = new Scanner(System.in);
        int var1 = scanner.nextInt();
        int var2 = scanner.nextInt();
        int sum = var1 + var2;
        int difference = var1 - var2;
        int product = var1 * var2;
        double quotient = (double) var1 / var2;
        System.out.println("The addition, subtraction, multiplication and division value of 2 numbers " + var1 +" and "+ var2 +" is" +
                " : " + sum + ", " + difference + ", " + product + ", " + quotient);
        scanner.close();
    }
}
