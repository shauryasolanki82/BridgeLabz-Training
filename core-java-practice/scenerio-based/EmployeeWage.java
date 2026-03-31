import java.util.Random;
import java.util.Scanner;

public class EmployeeWage {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    // Welcome message
    System.out.println("Welcome to Employee Wage Computation Program on Master Branch\n");

    // UC 1: Check Employee Attendance
    String[] attendance = { "Present", "Absent" };
    Random random = new Random();
    String status = attendance[random.nextInt(attendance.length)];

    System.out.println("Employee Attendance Check...");
    System.out.println("Employee is " + status);

    int wageRate = 20;
    int dailyWage = 0;

    // UC 4: Switch Case for Employee Type
    System.out.print("Enter the type of employee (part or full): ");
    String typeOfEmployee = sc.next();

    if (status.equals("Absent")) {
      dailyWage = 0;
      System.out.println("Employee is absent. Daily wage is ₹0");
    } else {
      switch (typeOfEmployee) {

        case "part":
          int partTimeHr = 8;
          dailyWage = wageRate * partTimeHr;
          System.out.println("Employee Type: Part Time");
          System.out.println("Daily Employee Wage: ₹" + dailyWage);
          break;

        case "full":
          int fullTimeHr = 8;
          dailyWage = wageRate * fullTimeHr;
          System.out.println("Employee Type: Full Time");
          System.out.println("Daily Employee Wage: ₹" + dailyWage);
          break;

        default:
          System.out.println("Invalid employee type!");
          sc.close();
          return;
      }
    }

    // UC 5: Monthly Wage Calculation
    int workingDays = 20;
    System.out.println("\nTotal Working Days in a Month: " + workingDays);
    System.out.println("Monthly Employee Wage: ₹" + (dailyWage * workingDays));

    // UC 6: Calculate wages till condition is reached
    System.out.println("\nMaximum Working Days: 20");
    System.out.println("Maximum Working Hours: 100");

    int totalHours = 0;
    int totalDays = 0;
    int totalWage = 0;

    while (totalHours < 100 && totalDays < 20) {
      totalDays++;

      int workHours = random.nextBoolean() ? 8 : 4; // full or part day
      totalHours += workHours;
      totalWage += workHours * wageRate;

      System.out.println(
          "Day " + totalDays + " → Hours Worked: " + workHours +
              " → Total Hours: " + totalHours);
    }

    System.out.println("\nCondition Reached!");
    System.out.println("Total Working Days: " + totalDays);
    System.out.println("Total Working Hours: " + totalHours);
    System.out.println("Total Employee Wage: ₹" + totalWage);

    System.out.println("\nThank You");
    sc.close();
  }
}