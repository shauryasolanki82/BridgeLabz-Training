import java.util.Scanner;
public class BonusOfEmployee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double salary = scanner.nextDouble();
        int yearsOfService = scanner.nextInt();
        double bonus = 0;
        if (yearsOfService > 5) {
            bonus = 0.05 * salary;
        }

        System.out.println("The bonus for the employee is: " + bonus);
        scanner.close();
    }
}
