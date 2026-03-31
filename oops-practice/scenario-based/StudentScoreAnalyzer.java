import java.util.InputMismatchException;
import java.util.Scanner;
class InvalidScoreException extends Exception{
    public InvalidScoreException(String msg){
        super(msg);
    }
}
public class StudentScoreAnalyzer {
    static void validateScore(int score) throws InvalidScoreException{
        if(score<0 || score>100){
            throw new InvalidScoreException("Score must be btw 0 and 100, given score: "+score);
        }
    }
    static int readPositiveInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int n = sc.nextInt();
                if (n > 0) return n;
                System.out.println("Please enter a positive number.");
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer.");
                sc.nextLine(); // clear bad input from buffer [web:143]
            }
        }
    }
    static int readValidScore(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int score = sc.nextInt();
                validateScore(score);
                return score;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer score.");
                sc.nextLine(); // clear bad input [web:143]
            } catch (InvalidScoreException e) {
                System.out.println("Invalid score: " + e.getMessage());
            }
        }
    }
    static int calculateAvgScore(int[] studentScores){
        int sum=0;
        for(int score:studentScores){
            sum+=score;
        }
        int avg=sum/studentScores.length;
        return avg;
    }
    static int findMax(int[] studentScores){
        int max=Integer.MIN_VALUE;
        for(int score:studentScores){
            if(max<score){
                max=score;
            }
        }
        return max;
    }
    static int findMin(int[] studentScores){
        int min=Integer.MAX_VALUE;
        for(int score:studentScores){
            if(min>score){
                min=score;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int numberOfStudents=readPositiveInt(sc, "Enter number of students: ");
        int[] studentScores=new int[numberOfStudents];
        for (int i = 0; i < numberOfStudents; i++) {
            studentScores[i] = readValidScore(sc, "Enter the score of student " + (i + 1) + ": ");
        }
        System.out.println("Average Score: "+calculateAvgScore(studentScores));
        System.out.println("Maximum Score: "+findMax(studentScores));
        System.out.println("Minimum Score: "+findMin(studentScores));
    }
}