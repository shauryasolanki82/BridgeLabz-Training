package scenario_based.hospital_management_system;

public class Person {
    protected int id;
    protected String name;
    protected int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return "[" + id + "] " + name;
    }
}
