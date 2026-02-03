package reflections;
import java.lang.reflect.*;

class Person {
    private int age = 20;
}

public class PrivateFieldAccess {
    public static void main(String[] args) throws Exception {
        Person p = new Person();
        Field f = p.getClass().getDeclaredField("age");
        f.setAccessible(true);
        f.setInt(p, 35);
        System.out.println(f.getInt(p));
    }
}
