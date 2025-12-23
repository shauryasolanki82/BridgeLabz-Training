import java.util.Scanner;
import java.util.Random;

public class EligibleToVote {

    // Method to generate random 2-digit ages for n students
    public static int[] generateAges(int n) {

        int[] ages = new int[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            // Generates random 2-digit age between 10 and 99
            ages[i] = random.nextInt(90) + 10;
        }

        return ages;
    }

    // Method to check voting eligibility
    // Returns 2D String array: {{age, canVote(true/false)}}
    public static String[][] checkVotingEligibility(int[] ages) {

        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {

            result[i][0] = String.valueOf(ages[i]);

            if (ages[i] < 0) {
                result[i][1] = "false";
            } else if (ages[i] >= 18) {
                result[i][1] = "true";
            } else {
                result[i][1] = "false";
            }
        }

        return result;
    }

    // Method to display the 2D array in tabular format
    public static void displayTable(String[][] data) {

        System.out.println("\nAge\tCan Vote");
        System.out.println("----------------");

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t" + data[i][1]);
        }
    }

    // Main method
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numberOfStudents = scanner.nextInt();

        int[] ages = generateAges(numberOfStudents);
        String[][] votingResult = checkVotingEligibility(ages);

        displayTable(votingResult);

        scanner.close();
    }
}
//voiting eligliblity