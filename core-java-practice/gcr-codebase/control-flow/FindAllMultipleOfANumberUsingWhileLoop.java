import java.util.Scanner;
public class FindAllMultipleOfANumberUsingWhileLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int limit = scanner.nextInt();

        int i = 1;
        while (i <= limit) {
            if (i % number == 0) {
                System.out.println(i);
            }
            i++;
        }
        scanner.close();
    }
}
