import java.util.Scanner;
public class CentimetersToFeetAndInches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double centimeters = scanner.nextDouble(); // Example input in centimeters
        double inches = centimeters / 2.54;
        double feet =  inches / 12.0;
        double remainingInches = inches % 12;

        System.out.println(centimeters + " cm is equal to " + feet + " feet and " + remainingInches + " inches.");
        scanner.close();
    }
}
