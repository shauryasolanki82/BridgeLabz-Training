import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class RohanLibraryReminderApp{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int fine = 0;
        for(int i=1;i<=5;i++){
            System.out.println("Enter date's in yyyy-mm-dd format");
            System.out.println("Enter due date");
            String input1 = sc.nextLine();
            LocalDate returnDate = LocalDate.parse(input1);
            System.out.println("enter return Date");
            String input2 = sc.nextLine();
            LocalDate dueDate = LocalDate.parse(input2);
            int totalDays = (int)ChronoUnit.DAYS.between(dueDate, returnDate);
            if(totalDays>0){
                System.out.println("Fine of this book is "+totalDays*5);
                fine+=totalDays*5;
            }
            else{
                System.out.println("You submitted the book on time");
            }
        }
        System.out.println("total fines of 5 books is "+ fine);
        sc.close();
    }
}