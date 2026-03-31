import java.util.Scanner;
import java.util.Random;

public class StudentScoreCard {

    // a. Generate random PCM scores
    static int[][] generatePCMScores(int students) {
        Random random = new Random();
        int[][] pcm = new int[students][3];

        for (int i = 0; i < students; i++) {
            pcm[i][0] = random.nextInt(90) + 10; // Physics
            pcm[i][1] = random.nextInt(90) + 10; // Chemistry
            pcm[i][2] = random.nextInt(90) + 10; // Maths
        }
        return pcm;
    }

    // b. Calculate total, average, percentage
    static double[][] calculateResults(int[][] pcm) {
        int students = pcm.length;
        double[][] results = new double[students][3];

        for (int i = 0; i < students; i++) {
            int total = pcm[i][0] + pcm[i][1] + pcm[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            results[i][0] = total;
            results[i][1] = Math.round(average * 100) / 100.0;
            results[i][2] = Math.round(percentage * 100) / 100.0;
        }
        return results;
    }

    // c. Calculate grades
    static String[][] calculateGrades(double[][] results) {
        int students = results.length;
        String[][] grades = new String[students][1];

        for (int i = 0; i < students; i++) {
            double percent = results[i][2];

            if (percent >= 80)
                grades[i][0] = "A";
            else if (percent >= 70)
                grades[i][0] = "B";
            else if (percent >= 60)
                grades[i][0] = "C";
            else if (percent >= 50)
                grades[i][0] = "D";
            else if (percent >= 40)
                grades[i][0] = "E";
            else
                grades[i][0] = "R";
        }
        return grades;
    }

    // d. Display scorecard
    static void displayScoreCard(int[][] pcm, double[][] results, String[][] grades) {
        System.out.println("\nStudent Scorecard");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("ID\tPhysics\tChemistry\tMaths\tTotal\tAvg\t%\tGrade");
        System.out.println("---------------------------------------------------------------------------");

        for (int i = 0; i < pcm.length; i++) {
            System.out.println(
                (i + 1) + "\t" +
                pcm[i][0] + "\t" +
                pcm[i][1] + "\t\t" +
                pcm[i][2] + "\t" +
                (int) results[i][0] + "\t" +
                results[i][1] + "\t" +
                results[i][2] + "\t" +
                grades[i][0]
            );
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int students = scanner.nextInt();

        int[][] pcm = generatePCMScores(students);
        double[][] results = calculateResults(pcm);
        String[][] grades = calculateGrades(results);

        displayScoreCard(pcm, results, grades);
        scanner.close();
    }
}
