package scenario_based.student_course_registration_system;

public class SemesterRegistration extends RegistrationService {
    private static final int MAX_COURSES = 3;

    @Override
    public void register(Student s, Course c) throws CourseLimitExceededException {
        if (s.getEnrolledCourses().size() >= MAX_COURSES) {
            throw new CourseLimitExceededException("Limit Reached! Student cannot take more than " + MAX_COURSES + " courses.");
        }
        s.addCourse(c);
        System.out.println("Success: " + s.name + " registered for " + c.getTitle());
    }
}
