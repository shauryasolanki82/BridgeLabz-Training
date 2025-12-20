import java.util.Scanner;
public class CalculateGradesOfPCM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of students:");
        int numberOfStudents = scanner.nextInt();

        int[][] marks = new int[numberOfStudents][3]; // 3 subjects: Physics, Chemistry, Maths
        double[] percentages = new double[numberOfStudents];
        char[] grades = new char[numberOfStudents];

        // Taking input for marks
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Enter marks for student " + (i + 1) + " in Physics, Chemistry, and Maths:");
            for (int j = 0; j < 3; j++) {
                int mark = scanner.nextInt();
                if (mark < 0) {
                    System.out.println("Please enter positive values for marks.");
                    j--; // Decrement index to re-enter the mark
                } else {
                    marks[i][j] = mark;
                }
            }
        }

        // Calculating percentages and grades
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
                grades[i] = 'F';
            } else {
                grades[i] = 'E';
            }
        }

        // Displaying results
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Student " + (i + 1) + ": Marks = [" + marks[i][0] + ", " + marks[i][1] + ", " + marks[i][2] + "], Percentage = " + percentages[i] + "%, Grade = " + grades[i]);
        }

        scanner.close();
    }
}
