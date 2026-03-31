import java.util.Scanner;
public class MultiplicationOfANumberFromSixToNine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = scanner.nextInt();
        //declare array to hold multiplication results from 6 to 9
        int[] multiplicationResult = new int[4];
        //calculate multiplication table from 6 to 9
        for (int i = 6; i <= 9; i++) {
            multiplicationResult[i - 6] = number * i;
        }
        //print multiplication results
        for (int i = 0; i < multiplicationResult.length; i++) {
            System.out.println(number + " * " + (i + 6) + " = " + multiplicationResult[i]);
        }
        scanner.close();
    }
}
