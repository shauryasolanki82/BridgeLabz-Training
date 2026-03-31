import java.util.Scanner;
public class IntOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt(); // Example input for a
        int b = scanner.nextInt(); // Example input for b
        int c = scanner.nextInt(); // Example input for c
        int res1 = a + b * c;
        int res2 = a * b + c;  
        int res3 = c + a / b;
        int res4 = a % b + c;


        System.out.println("The result of Operation is: " + res1 + ", " + res2 + ", " + res3 + ", " + res4);
        scanner.close();
    }
}
