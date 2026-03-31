import java.time.LocalDate;
import java.util.Scanner;
public class DateArithmatic {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a date (yyyy-mm-dd): ");
    String date = sc.nextLine();
    LocalDate d = LocalDate.parse(date);
    //new date
    LocalDate newDate = d.plusDays(7).plusMonths(1).plusYears(2);
    System.out.println("After adding 7 days, 1 month, and 2 years: "+newDate);
    // new date after subtract 3 weeks
    System.out.println("After subtract 3 weeks: "+newDate.minusWeeks(3));
    sc.close();
  }
}
