import java.util.Scanner;
public class PrintOddEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " is Even");
            } else {
                System.out.println(i + " is Odd");
            }
        }
        scanner.close();
    }
}
