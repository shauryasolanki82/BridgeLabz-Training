import java.util.Scanner;
public class YoungestAmongThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age1 = scanner.nextInt();
        int age2 = scanner.nextInt();
        int age3 = scanner.nextInt();

        if (age1 < age2 && age1 < age3) {
            System.out.println("The youngest person is the first one with age: " + age1);
        } else if (age2 < age1 && age2 < age3) {
            System.out.println("The youngest person is the second one with age: " + age2);
        } else if (age3 < age1 && age3 < age2) {
            System.out.println("The youngest person is the third one with age: " + age3);
        } else {
            System.out.println("There is a tie for the youngest age.");
        }
        scanner.close();
    }
}
