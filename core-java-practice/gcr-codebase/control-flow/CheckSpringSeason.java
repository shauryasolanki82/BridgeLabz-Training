import java.util.Scanner;

public class CheckSpringSeason {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        int day = scanner.nextInt();

        if ((month >= 3 && day >= 20) &&(month <=6 && day <= 31)) {
            System.out.println("Spring Season.");
        } else {
            System.out.println("Not in the Spring Season.");
        }
        scanner.close();
    }
}
