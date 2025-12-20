import java.util.Scanner;
public class FindAllMultipleOfANumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int limit = scanner.nextInt();

        for (int i = 1; i <= limit; i++) {
            if (i % number == 0) {
                System.out.println(i);
            }
        }
        scanner.close();
    }
}
