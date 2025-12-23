import java.util.Scanner;

public class StringIndexOutOfBounds {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // input for string
        String text = sc.next();

        // First: generate the exception
        System.out.println("\nGenerating exception:");
        try {
            showException(text);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException occurred.");
        }

        // Second: handle the exception properly
        System.out.println("\nHandling exception:");
        handleException(text);

        sc.close();
    }


    // This method will cause the exception
    static void showException(String text) {
        // accessing index beyond string length
        System.out.println(text.charAt(text.length()));
    }

    // This method will handle the exception
    static void handleException(String text) {
        try {
            System.out.println(text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception handled!");
            System.out.println("You tried to access an index outside the string length.");
        }
    }
}