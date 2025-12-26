package methods;
import java.util.*;

public class StudentScores {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = input.nextInt();
        int[][] scores = generateScores(numStudents);
        double[][] stats = calculateStatistics(scores);
        displayScorecard(scores, stats);
        input.close();
    }

    public static int[][] generateScores(int n) {
        int[][] scores = new int[n][3];
        for (int i = 0; i < n; i++) {
            scores[i][0] = (int)(Math.random() * 90) + 10;
            scores[i][1] = (int)(Math.random() * 90) + 10;
            scores[i][2] = (int)(Math.random() * 90) + 10; 
        }
        return scores;
    }

    public static double[][] calculateStatistics(int[][] scores) {
        double[][] stats = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            int p = scores[i][0];
            int c = scores[i][1];
            int m = scores[i][2];
            double total = p + c + m;
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100.0;
            stats[i][0] = total;
            stats[i][1] = roundToTwoDecimals(average);
            stats[i][2] = roundToTwoDecimals(percentage);
        }
        return stats;
    }

    public static double roundToTwoDecimals(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    public static void displayScorecard(int[][] scores, double[][] stats) {
        System.out.println("Std ID\tPhy\tChem\tMath\tTotal\tAvg\tPercentage");
        for (int i = 0; i < scores.length; i++) {
            int phy = scores[i][0];
            int chem = scores[i][1];
            int math = scores[i][2];
            double total = stats[i][0];
            double avg = stats[i][1];
            double perc = stats[i][2];
            System.out.println((i + 1) + "\t" + phy + "\t" + chem + "\t" + math + "\t" + 
                               (int)total + "\t" + avg + "\t" + perc + "%");
        }
    }
}