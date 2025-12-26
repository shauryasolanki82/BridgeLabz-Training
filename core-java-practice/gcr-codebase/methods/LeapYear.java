
import java.util.Scanner;

public class LeapYear{
	public static void checkLeapYear(int year) {
        if (year < 1582) {
            System.out.println("The LeapYear program only works for year >= 1582.");
            return;
        }
        boolean isLeap;
        if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
        	isLeap = true;
        }else {
        	isLeap = false;
        }
        if (isLeap) {
            System.out.println(year + " is a Leap Year.");
        } else {
            System.out.println(year + " is not a Leap Year.");
        }
	}
	
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = input.nextInt();
        checkLeapYear(year);
        input.close();
    }
}