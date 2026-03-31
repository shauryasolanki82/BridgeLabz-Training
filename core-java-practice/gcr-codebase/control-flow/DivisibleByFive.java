import java.util.Scanner;
public class DivisibleByFive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt(); // Example input number

        if (number % 5 == 0) {
            System.out.println( "Is the number "+number+" divisible by 5? : true");
        } else {
            System.out.println( "Is the number "+number+" divisible by 5? : false");
        }
        scanner.close();
    }
}
