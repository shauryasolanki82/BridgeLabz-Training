
import java.util.Scanner;
public class MultiDArrayToStoreHeightWeightAndBmi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of persons:");
        int n = scanner.nextInt();
        double[][] personData = new double[n][3];
        String[] weightStatus = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter weight for person " + (i + 1) + ":");
            double weight = scanner.nextDouble();
            while (weight <= 0) {
                System.out.println("Please enter a positive weight:");
                weight = scanner.nextDouble();
            }
            System.out.println("Enter height for person " + (i + 1) + ":");
            double height = scanner.nextDouble();
            while (height <= 0) {
                System.out.println("Please enter a positive height:");
                height = scanner.nextDouble();
            }
            personData[i][0] = weight;
            personData[i][1] = height;
            personData[i][2] = weight / (height * height);
            if (personData[i][2] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] < 25.0) {
                weightStatus[i] = "Normal";
            } else if (personData[i][2] < 30.0) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }
        System.out.println("Height\tWeight\tBMI\tWeight Status");
        for (int i = 0; i < n; i++) {
            System.out.println(personData[i][1] + "\t" + personData[i][0] + "\t" + personData[i][2] + "\t" + weightStatus[i]);
        }
        scanner.close();
    }
}