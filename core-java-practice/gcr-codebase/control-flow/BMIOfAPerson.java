import java.util.Scanner;
public class BMIOfAPerson {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double weight = scanner.nextDouble();
        double height = scanner.nextDouble();
        double bmi = weight / (height * height);
        System.out.println("BMI: " + bmi);
        if (bmi <= 18.4) {
            System.out.println("Underweight");
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            System.out.println("Normal weight");
        } else if (bmi >= 25 && bmi < 39.9) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
        scanner.close();
    }
}