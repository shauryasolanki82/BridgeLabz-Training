import java.util.Scanner;
public class StoreMultipleValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Array to store up to 10 numbers
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;
        // Loop to read numbers until user decides to stop or array is full
        while (true) {
            System.out.println("Enter a number (or 0 or negative to stop):");
            double number = scanner.nextDouble();

            if (number <= 0 || index >= 10) {
                break;
            }

            numbers[index] = number;
            total += number;
            index++;
        }

        // Print all stored numbers
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
        }
        System.out.println("Sum of all numbers: " + total);
        scanner.close();
    }
}