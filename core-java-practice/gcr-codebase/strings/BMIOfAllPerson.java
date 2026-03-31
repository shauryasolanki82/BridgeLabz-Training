import java.util.Scanner;
public class BMIOfAllPerson {
    // Function to calculate BMI
    public static double calculateBMI(double height, double weight) {
        return weight / (height * height);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n = scanner.nextInt();
        double[] heights = new double[n];
        double[] weights = new double[n];

        // Input heights and weights
        for (int i = 0; i < n; i++) {
            System.out.print("Enter height (in meters) of person " + (i + 1) + ": ");
            heights[i] = scanner.nextDouble();
            System.out.print("Enter weight (in kg) of person " + (i + 1) + ": ");
            weights[i] = scanner.nextDouble();
        }

        // Calculate and display BMI for each person
        for (int i = 0; i < n; i++) {
            double bmi = calculateBMI(heights[i], weights[i]);
            System.out.printf("BMI of person %d: %.2f%n", (i + 1), bmi);
        }

        scanner.close();
    }
}
