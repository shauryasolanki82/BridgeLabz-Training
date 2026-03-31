import java.util.Scanner;
public class EligibleToVote {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ages = new int[10];

        // Taking user input for ages
        System.out.println("Enter the ages of 10 students:");
        for (int i = 0; i < ages.length; i++) {
            ages[i] = scanner.nextInt();
        }

        // Checking eligibility to vote
        for (int age : ages) {
            if (age < 0) {
                System.out.println("Invalid age: " + age);
            } else if (age >= 18) {
                System.out.println("The student with the age " + age + " can vote.");
            } else {
                System.out.println("The student with the age " + age + " cannot vote.");
            }
        }
        scanner.close();
    }
}
