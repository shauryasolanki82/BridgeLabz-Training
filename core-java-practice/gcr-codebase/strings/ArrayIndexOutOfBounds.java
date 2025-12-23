import java.util.Scanner;

public class ArrayIndexOutOfBounds {

    // This method will generate ArrayIndexOutOfBoundsException
    static void generateException(String[] names) {
        // accessing index greater than array length
        System.out.println(names[10]);
    }

    // This method handles ArrayIndexOutOfBoundsException
    static void handleException(String[] names) {
        try {
            System.out.println(names[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of names: ");
        int size = scanner.nextInt();
        scanner.nextLine();

        String[] names = new String[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = scanner.nextLine();
        }

        // This call will abruptly stop the program
        generateException(names);

        // This call will handle the exception properly
        handleException(names);

        scanner.close();
    }
}