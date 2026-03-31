import java.util.Scanner;
public class StoreTheMarksOfPCMInTwoDArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of students:");
        int numberOfStudents = scanner.nextInt();

        int[][] marks = new int[numberOfStudents][3];
        double[] percentages = new double[numberOfStudents];
        char[] grades = new char[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Enter marks for student " + (i + 1) + " in Physics, Chemistry, and Maths:");
            for (int j = 0; j < 3; j++) {
                int mark = scanner.nextInt();
                if (mark < 0) {
                    System.out.println("Please enter positive values only.");
                    j--; // decrement index to re-enter the mark
                } else {
                    marks[i][j] = mark;
                }
            }
        }

        for (int i = 0; i < numberOfStudents; i++) {
            int totalMarks = marks[i][0] + marks[i][1] + marks[i][2];
            percentages[i] = (totalMarks / 300.0) * 100;

            if (percentages[i] >= 80) {
                grades[i] = 'A';
            } else if (percentages[i] >= 70) {
                grades[i] = 'B';
            } else if (percentages[i] >= 60) {
                grades[i] = 'C';
            } else if (percentages[i] >= 50) {
                grades[i] = 'D';
            } else if (percentages[i] >= 40) {
                grades[i] = 'R';
            } else {
                grades[i] = 'E';
            }
        }

        System.out.println("Student\tPhysics\tChemistry\tMaths\tPercentage\tGrade");
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print((i + 1) + "\t");
            for (int j = 0; j < 3; j++) {
                System.out.print(marks[i][j] + "\t");
            }
            System.out.printf("%.2f\t\t%c\n", percentages[i], grades[i]);
        }

        scanner.close();
    }
}
