package methods;
import java.util.Scanner;

public class EuclideanDistance {

    public static double findEuclideanDistance(double x1, double y1, double x2, double y2) {
        // Formula: sqrt( (x2-x1)^2 + (y2-y1)^2 )
        double x = Math.pow((x2 - x1), 2);
        double y = Math.pow((y2 - y1), 2);
        
        return Math.sqrt(x + y);
    }

    public static double[] findLineEquation(double x1, double y1, double x2, double y2) {
        double[] result = new double[2];
        double m = (y2 - y1) / (x2 - x1);
        double b = y1 - (m * x1);
        result[0] = m;
        result[1] = b;
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter coordinates for Point 1 (x1 y1): ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        System.out.println("Enter coordinates for Point 2 (x2 y2): ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double distance = findEuclideanDistance(x1, y1, x2, y2);
        System.out.printf("Euclidean Distance: %.2f%n", distance);
        if (x1 == x2) {
            System.out.println("Line Equation: x = " + x1 + " (Vertical Line, slope is undefined)");
        } else {
            double[] equationParams = findLineEquation(x1, y1, x2, y2);
            double m = equationParams[0];
            double b = equationParams[1];
            System.out.printf("Line Equation: y = %.2fx %s %.2f%n", 
                m, (b >= 0 ? "+" : "-"), Math.abs(b));
        }
        input.close();
    }
}
