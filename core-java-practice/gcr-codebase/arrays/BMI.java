import java.util.Scanner;
public class BMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of persons:");
        int n = scanner.nextInt();
        double[] weights = new double[n];
        double[] heights = new double[n];
        double[] BMIs = new double[n];
        String[] weightStatuses = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter weight for person " + (i + 1) + ":");
            weights[i] = scanner.nextDouble();
            System.out.println("Enter height for person " + (i + 1) + ":");
            heights[i] = scanner.nextDouble();
            BMIs[i] = weights[i] / (heights[i] * heights[i]);
            if (BMIs[i] < 18.5) {
                weightStatuses[i] = "Underweight";
            } else if (BMIs[i] < 25.0) {
                weightStatuses[i] = "Normal";
            } else if (BMIs[i] < 30.0) {
                weightStatuses[i] = "Overweight";
            } else {
                weightStatuses[i] = "Obese";
            }
        }
        System.out.println("Height\tWeight\tBMI\tWeight Status");
        for (int i = 0; i < n; i++) {
            System.out.println(heights[i] + "\t" + weights[i] + "\t" + BMIs[i] + "\t" + weightStatuses[i]);
        }
        scanner.close();
    }
}