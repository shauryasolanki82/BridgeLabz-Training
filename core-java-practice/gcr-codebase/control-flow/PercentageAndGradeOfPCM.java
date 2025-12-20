import java.util.Scanner;
public class PercentageAndGradeOfPCM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int physics = scanner.nextInt();
        int chemistry = scanner.nextInt();
        int mathematics = scanner.nextInt();

        int total = physics + chemistry + mathematics;
        double percentage = (total * 100.0) / 300;

        System.out.println("Total Marks: " + total);
        System.out.println("Percentage: " + percentage);

        
         if (percentage >= 80) {
            System.out.println("Grade: A");
        } else if (percentage >= 70) {
            System.out.println("Grade: B");
        } else if (percentage >= 60) {
            System.out.println("Grade: C");
        } else if (percentage >= 50) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F");
        }
        scanner.close();
    }
}