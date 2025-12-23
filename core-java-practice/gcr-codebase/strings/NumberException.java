import java.util.Scanner;

public class NumberException {

    // This method will generate NumberFormatException
    static void generateException(String text) {
        int number = Integer.parseInt(text); // exception occurs here
        System.out.println("Number is: " + number);
    }

    // This method handles NumberFormatException and RuntimeException
    static void handleException(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println("Number is: " + number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a value: ");
        String input = scanner.nextLine();

        // This call will abruptly stop the program if input is not a number
        generateException(input);

        // This call will handle the exception safely
        handleException(input);

        scanner.close();
    }
}