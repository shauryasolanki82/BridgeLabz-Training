package scenario_based.student_course_registration_system;

public abstract class RegistrationService {
    public abstract void register(Student s, Course c) throws CourseLimitExceededException;
}
