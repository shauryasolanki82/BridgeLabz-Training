import java.util.Scanner;
public class FindSideOfSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int perimeter = scanner.nextInt(); // Example area
        int side = perimeter / 4;
        System.out.println("The side of the square with perimeter " + perimeter + " is: " + side);
        scanner.close();
    }
}
