import java.util.Scanner;
public class MeanHeightOfPlayers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] heights = new double[11];
        double sum = 0.0;
        System.out.println("Enter the heights of 11 players:");
        for (int i = 0; i < 11; i++) {
            heights[i] = scanner.nextDouble();
            sum += heights[i];
        }
        double mean = sum / 11;
        System.out.println("Mean height of the football team: " + mean);
        scanner.close();
    }
}