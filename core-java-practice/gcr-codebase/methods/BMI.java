
import java.util.Scanner;

public class BMI {
	public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightInMeters = data[i][1] / 100.0;
            data[i][2] = weight / (heightInMeters * heightInMeters);
        }
    }

    public static String[] getBMIStatus(double[][] data) {
        String[] status = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];
            if (bmi <= 18.4) {
                status[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi <= 24.9) {
                status[i] = "Normal";
            } else if (bmi >= 25.0 && bmi <= 39.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
        return status;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[][] data = new double[10][3];
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter details for Member " + (i + 1) + ":");
            System.out.print("Weight (kg): ");
            data[i][0] = input.nextDouble();
            System.out.print("Height (cm): ");
            data[i][1] = input.nextDouble();
        }
        calculateBMI(data);
        String[] status = getBMIStatus(data);
        System.out.printf("%-10s %-10s %-10s %-10s %-15s\n", "Member", "Weight", "Height", "BMI", "Status");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%-10d %-10.2f %-10.2f %-10.2f %-15s\n", 
                (i + 1), data[i][0], data[i][1], data[i][2], status[i]);
        }
        input.close();
    }
}