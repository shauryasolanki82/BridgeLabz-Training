package reflections;
import java.lang.reflect.*;

class Student {
    String name;
    int rollNo;
    public Student() {}
    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }
    public String toString() {
        return name + " " + rollNo;
    }
}

public class DynamicObjectCreation {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("Student");
        Constructor<?> ctor = cls.getDeclaredConstructor(String.class, int.class);
        Object obj = ctor.newInstance("Saurav", 101);
        System.out.println(obj);
    }
}
