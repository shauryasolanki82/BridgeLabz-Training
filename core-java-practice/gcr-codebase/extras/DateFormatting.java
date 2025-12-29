import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class DateFormatting {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter date (yyyy-mm-dd): ");
    String input = sc.nextLine();
    LocalDate date = LocalDate.parse(input);
    System.out.println("Output in yyyy-MM-dd: "+date);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    System.out.println("Output in dd/MM/yyyy: "+date.format(formatter));
    DateTimeFormatter f2 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");
    System.out.println("Output in EEE, MMM dd, yyyy: "+date.format(f2));

    sc.close();
  }
}
