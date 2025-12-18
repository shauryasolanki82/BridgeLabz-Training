import java.util.Scanner;
public class AreaOfTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double base = scanner.nextDouble(); // Example base
        double height = scanner.nextDouble(); // Example height
        double area = 0.5 * base * height;
        System.out.println("The area of the triangle with base " + base + " and height " + height + " is: " + area);
        scanner.close();
    }
}
