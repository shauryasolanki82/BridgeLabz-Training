
import java.util.Scanner;

public class Calendar {
	
    public static String monthName(int month) {
        String[] months = {
            "", "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        return months[month];
    }
    
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int daysInMonth(int month, int year) {
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return days[month];
    }

    public static int startDay(int m, int y) {
        int d = 1; // We want the first day of the month
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;
        return d0; // 0 for Sunday, 1 for Monday, etc.
    }
    
    public static void printCalendar(int month, int year) {
        String monthName = monthName(month);
        int daysInMonth = daysInMonth(month, year);
        int startDay = startDay(month, year);
        System.out.println("  " + monthName + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        for (int i = 0; i < startDay; i++) {
            System.out.print("    ");
        }
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%3d ", day);
            if ((day + startDay) % 7 == 0 || day == daysInMonth) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter month (1-12) and year (e.g., 07 2005): ");
        int month = input.nextInt();
        int year = input.nextInt();
        printCalendar(month, year);
        input.close();
    }
}