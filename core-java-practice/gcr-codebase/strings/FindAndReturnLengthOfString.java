import java.util.Scanner;

public class FindAndReturnLengthOfString {

    // User-defined method to find string length without using length()
    public static int findLength(String str) {
        int count = 0;

        try {
            // Infinite loop
            while (true) {
                str.charAt(count); // Access character at index
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Exception occurs when index exceeds string length
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input using next()
        System.out.print("Enter a string: ");
        String input = sc.next();

        // Call user-defined method
        int customLength = findLength(input);

        // Call built-in length() method
        int builtInLength = input.length();

        // Display results
        System.out.println("Length using user-defined method: " + customLength);
        System.out.println("Length using built-in length() method: " + builtInLength);

        sc.close();
    }
}

