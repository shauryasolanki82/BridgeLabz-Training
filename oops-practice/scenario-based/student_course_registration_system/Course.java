package scenario_based.student_course_registration_system;

public class Course {
    private String courseCode;
    private String title;

    public Course(String courseCode, String title) {
        this.courseCode = courseCode;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "[" + courseCode + "] " + title;
    }
}