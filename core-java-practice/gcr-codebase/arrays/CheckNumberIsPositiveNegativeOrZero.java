import java.util.Scanner;
public class CheckNumberIsPositiveNegativeOrZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //defining an array to hold 5 numbers
        int[] numbers = new int[5];

        // Taking user input for 5 numbers
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        // Checking each number
        for (int number : numbers) {
            if (number > 0) {
                if (number % 2 == 0) {
                    System.out.println(number + " is a positive even number.");
                } else {
                    System.out.println(number + " is a positive odd number.");
                }
            } else if (number < 0) {
                System.out.println(number + " is a negative number.");
            } else {
                System.out.println("The number is zero.");
            }
        }

        // Comparing first and last elements
        if (numbers[0] == numbers[numbers.length - 1]) {
            System.out.println("The first and last elements are equal.");
        } else if (numbers[0] > numbers[numbers.length - 1]) {
            System.out.println("The first element is greater than the last element.");
        } else {
            System.out.println("The first element is less than the last element.");
        }

        scanner.close();
    }
}
