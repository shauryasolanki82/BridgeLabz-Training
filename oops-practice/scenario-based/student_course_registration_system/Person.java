package scenario_based.student_course_registration_system;

public class Person {
    protected String name;
    protected String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void getDetails() {
        System.out.println("Name: " + name + " | Email: " + email);
    }
}
