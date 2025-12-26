package methods;
import java.util.Scanner;

public class RootsOfQuadraticEquation {
	 public static double[] findRoots(double a, double b, double c) {
	        double delta = Math.pow(b, 2) - (4 * a * c);
	        if (delta > 0) {
	            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
	            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
	            return new double[]{root1, root2};
	        } else if (delta == 0) {
	            double root = -b / (2 * a);
	            return new double[]{root};
	        } else {
	            return new double[]{};
	        }
	    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a: ");
        double a = input.nextDouble();
        System.out.print("Enter b: ");
        double b = input.nextDouble();
        System.out.print("Enter c: ");
        double c = input.nextDouble();
        double[] roots = findRoots(a, b, c);
        if (roots.length == 0) {
            System.out.println("The equation has no real roots (delta is negative).");
        } else if (roots.length == 1) {
            System.out.println("The equation has one root: " + roots[0]);
        } else {
            System.out.println("Root 1: " + roots[0]);
            System.out.println("Root 2: " + roots[1]);
        }
        input.close();
    }
}