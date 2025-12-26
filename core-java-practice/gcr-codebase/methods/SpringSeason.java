package methods;
import java.util.Scanner;

public class SpringSeason {
	public static void season(int month, int day) {
		if(month == 3 && day >= 20) {
            System.out.println("Its a Spring Season");
        }else if(month == 4 || month == 5) {
            System.out.println("Its a Spring Season");
        }else if(month == 6 && day <= 20) {
            System.out.println("Its a Spring Season");
        }else{
            System.out.println("Not a Spring Season");
        }
	}
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int month = input.nextInt();
        int day = input.nextInt();
        season(month, day);
        input.close();
    }
}