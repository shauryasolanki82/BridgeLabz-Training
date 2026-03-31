import java.util.Scanner;
public class MultiplicationOfTableBetweenSixToNine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number between 6 and 9");
        int number = scanner.nextInt();

        if (number >= 6 && number <= 9) {
            for (int i = 1; i <= 10; i++) {
                System.out.println(number + " x " + i + " = " + (number * i));
            }
        } else {
            System.out.println("Please enter a number between 6 and 9.");
        }
        scanner.close();
    }
}
