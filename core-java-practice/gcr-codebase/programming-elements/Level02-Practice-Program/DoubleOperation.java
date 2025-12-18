import java.util.Scanner;
public class DoubleOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble(); // Example input for a
        double b = scanner.nextDouble(); // Example input for b
        double c = scanner.nextDouble(); // Example input for c

        double sum = a + b + c;
        double difference = a - b - c;  
        double product = a * b * c;
        double quotient = a / b / c;

        System.out.println("The result of Operation is: " + sum + ", " + difference + ", " + product + ", " + quotient);
        scanner.close();
    }
}
