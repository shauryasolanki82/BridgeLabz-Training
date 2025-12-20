import java.util.Scanner;

public class EligibleToVote {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();

        if (age >= 18) {
            System.out.println("the person age is "+age+" can vote");
        } else {
            System.out.println("the person age is "+age+" cannot vote");
        }
        scanner.close();
    }
}
