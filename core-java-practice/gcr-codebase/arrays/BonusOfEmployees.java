import java.util.Scanner;
public class BonusOfEmployees {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] salaries = new double[10];
        double[] yearsOfService = new double[10];
        double[] bonuses = new double[10];
        double[] newSalaries = new double[10];
        double totalBonus = 0.0;
        double totalOldSalary = 0.0;
        double totalNewSalary = 0.0;

        // Input salaries and years of service
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter salary for employee " + (i + 1) + ":");
            double salary = scanner.nextDouble();
            System.out.println("Enter years of service for employee " + (i + 1) + ":");
            double years = scanner.nextDouble();

            if (salary <= 0 || years < 0) {
                System.out.println("Invalid input. Please enter again.");
                i--; // Decrement index to repeat input for this employee
                continue;
            }

            salaries[i] = salary;
            yearsOfService[i] = years;
        }

        // Calculate bonuses and new salaries
        for (int i = 0; i < 10; i++) {
            double bonus;
            if (yearsOfService[i] > 5) {
                bonus = salaries[i] * 0.05;
            } else {
                bonus = salaries[i] * 0.02;
            }
            bonuses[i] = bonus;
            newSalaries[i] = salaries[i] + bonus;

            totalBonus += bonus;
            totalOldSalary += salaries[i];
            totalNewSalary += newSalaries[i];
        }

        // Print totals
        System.out.println("Total bonus payout: " + totalBonus);
        System.out.println("Total old salary: " + totalOldSalary);
        System.out.println("Total new salary: " + totalNewSalary);

        scanner.close();
    }
}
