package scenario_based.student_course_registration_system;
import java.util.*;

public class Student extends Person {
    private String studentId;
    private List<Course> enrolledCourses;
    private Map<String, String> grades;
    public Student(String name, String email, String studentId) {
        super(name, email);
        this.studentId = studentId;
        this.enrolledCourses = new ArrayList<>();
        this.grades = new HashMap<>();
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }
    public void addCourse(Course c) {
        enrolledCourses.add(c);
    }
    public void dropCourse(Course c) {
        if (enrolledCourses.contains(c)) {
            enrolledCourses.remove(c);
            System.out.println("Dropped: " + c.getTitle());
        }
    }
    public void assignGrade(Course c, String grade) {
        grades.put(c.getTitle(), grade);
    }
    public void viewGrades() {
        System.out.println("Grades for " + name);
        if (grades.isEmpty()) {
            System.out.println("No grades available.");
        } else {
            for (Map.Entry<String, String> entry : grades.entrySet()) {
                System.out.println("Course: " + entry.getKey() + " | Grade: " + entry.getValue());
            }
        }
    }
}