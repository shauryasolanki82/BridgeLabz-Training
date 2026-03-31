import java.util.Scanner;
public class FeetToYardAndMilesDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int feet = scanner.nextInt(); // Example input in feet
        double yards = (double)(feet / 3.0);
        double miles = (double)(feet / 5280.0);

        System.out.println(feet + " feet is equal to " + yards + " yards and " + miles + " miles.");
        scanner.close();
    }
}
