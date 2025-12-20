import java.util.Scanner;
public class MayasBMIFitnessTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // user input height
        System.out.println("Enter height");
        double height = scanner.nextDouble();
        // user input weight
        System.out.println("Enter weight");
        double weight = scanner.nextDouble();
        // calculate BMI
        double bmi = weight / (height * height);
        if (bmi < 18.5) {
            System.out.println("Underweight");
        } else if (bmi >= 18.5 && bmi < 25.0) {
            System.out.println("Normal");
        } else {
            System.out.println("Overweight");
        }
        scanner.close();
    }
}