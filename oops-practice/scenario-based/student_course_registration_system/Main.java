package scenario_based.student_course_registration_system;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Anuj Udaywal", "anuj@gla.ac.in", "S101");
        student.getDetails();
        Course math = new Course("M101", "Calculus");
        Course physics = new Course("P101", "Physics");
        Course cs = new Course("CS101", "Java Programming");
        Course history = new Course("H101", "World History");
        RegistrationService registrar = new SemesterRegistration();
        System.out.println("Starting Registration");
        try {
            registrar.register(student, math);
            registrar.register(student, physics);
            registrar.register(student, cs);
            System.out.println("Attempting to register");
            registrar.register(student, history); 
        } catch (CourseLimitExceededException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        System.out.println("Grade Management");
        student.assignGrade(math, "A");
        student.assignGrade(cs, "B+");
        student.viewGrades();
    }
}
