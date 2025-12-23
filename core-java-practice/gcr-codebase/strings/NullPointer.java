public class NullPointer {

    // Method that may generate NullPointerException
    public static void accessStringLength(String text) {
        System.out.println("String length: " + text.length());
    }

    // Method to handle NullPointerException
    public static void safeAccessStringLength(String text) {
        try {
            accessStringLength(text);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException handled!");
            System.out.println("Reason: Attempted to access a method on a null String");
        }
    }

    public static void main(String[] args) {

        String text = null;

        System.out.println("Demonstrating NullPointerException:");
        try {
            accessStringLength(text);
        } catch (NullPointerException e) {
            System.out.println("Exception occurred in main()");
        }

        System.out.println("\nHandling NullPointerException safely:");
        safeAccessStringLength(text);
    }
}