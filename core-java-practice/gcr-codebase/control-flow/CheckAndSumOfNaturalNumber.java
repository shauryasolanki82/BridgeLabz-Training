import java.util.Scanner;

public class CheckAndSumOfNaturalNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if(number < 1) {
            System.out.println("The number"+ number +"is not a natural number.");
            
        }
        else{
        int sum = number * (number + 1) / 2;
        System.out.println("The sum of " + number + " natural number is: " + sum);
    }
        scanner.close();
    }
}