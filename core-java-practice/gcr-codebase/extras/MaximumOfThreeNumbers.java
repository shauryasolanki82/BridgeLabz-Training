// import java.util.Scanner;
// public class MaximumOfThreeNumbers {
//   public static void main(String[] args) {
//     Scanner sc = new Scanner(System.in);
//     System.out.print("Enter a number1 : ");
//     int n1 = sc.nextInt();
//     System.out.print("Enter a number2 : ");
//     int n2 = sc.nextInt();
//     System.out.print("Enter a number3 : ");
//     int n3 = sc.nextInt();
//     int maxNumber = Math.max(n1,Math.max(n2,n3));
//     System.out.println("Maximum number is "+maxNumber);
//     sc.close();
//   }
// }
import java.util.Scanner;
public class MaximumOfThreeNumbers {
    // Function to take integer input from the user
    public static int takeInput(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        sc.close();
        return sc.nextInt();
    }
    // Function to find the maximum of three numbers
    public static int findMaximum(int a, int b, int c) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        return max;
    }
    public static void main(String[] args) {
        // Take input
        int num1 = takeInput("Enter first number: ");
        int num2 = takeInput("Enter second number: ");
        int num3 = takeInput("Enter third number: ");
        // Find maximum
        int max = findMaximum(num1, num2, num3);
        // Display result
        System.out.println("Maximum number is: " + max);
    }
}
