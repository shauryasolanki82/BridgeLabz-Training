import java.util.*;

class InvalidMarkException extends Exception {
    public InvalidMarkException(String message) {
        super(message);
    }
}

class Student {
    private String name;
    private int rollNumber;
    private String[] subjects;
    private int[] marks;

    public Student(String name, int rollNumber, String[] subjects, int[] marks) throws InvalidMarkException {
        this.name = name;
        this.rollNumber = rollNumber;
        this.subjects = subjects;
        
        for (int mark : marks) {
            if (mark < 0 || mark > 100) {
                throw new InvalidMarkException("Invalid mark detected: " + mark + ". Marks must be between 0 and 100.");
            }
        }
        this.marks = marks;
    }

    public double calculateAverage() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return (double) total / marks.length;
    }

    public String assignGrade(double average) {
        if (average >= 90) return "A+";
        else if (average >= 80) return "A";
        else if (average >= 70) return "B";
        else if (average >= 60) return "C";
        else if (average >= 50) return "D";
        else return "F";
    }

    public void printReportCard() {
        double average = calculateAverage();
        String grade = assignGrade(average);
        int total = 0;
        for(int m : marks) total += m;

        System.out.printf(" Name: %-15s Roll No: %d\n", name, rollNumber);
        System.out.printf(" %-20s | %-10s \n", "SUBJECT", "MARKS");
        for (int i = 0; i < subjects.length; i++) {
            System.out.printf(" %-20s | %-10d \n", subjects[i], marks[i]);
        }
        System.out.printf(" %-20s | %-10d \n", "TOTAL", total);
        System.out.printf(" %-20s | %-10.2f \n", "AVERAGE", average);
        System.out.printf(" %-20s | %-10s \n", "GRADE", grade);
    }
}

public class StudentReportGenerator {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        String[] subjects = {"Mathematics", "Physics", "Chemistry", "English", "CS"};
        try {
            int[] marks1 = {85, 90, 78, 88, 92};
            Student s1 = new Student("Alice Smith", 101, subjects, marks1);
            studentList.add(s1);
        } catch (InvalidMarkException e) {
            System.err.println("Error creating student record: " + e.getMessage());
        }
        for (Student student : studentList) {
            student.printReportCard();
        }
    }
}