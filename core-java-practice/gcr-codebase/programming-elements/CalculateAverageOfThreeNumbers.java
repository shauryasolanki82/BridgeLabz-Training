import java.util.Scanner;
public class CalculateAverageOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1 = scanner.nextDouble(); 
        double num2 = scanner.nextDouble(); 
        double num3 = scanner.nextDouble(); 
        double average = (num1 + num2 + num3) / 3;
        System.out.println("The average of " + num1 + ", " + num2 + ", and " + num3 + " is: " + average);
    }
}