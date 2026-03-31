package reflections;
import java.lang.reflect.*;
import java.util.*;

public class ClassInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String className = sc.nextLine().trim();
        try {
            Class<?> cls = Class.forName(className);
            System.out.println(cls.getName());
            for (Constructor<?> c : cls.getDeclaredConstructors()) System.out.println(c);
            for (Field f : cls.getDeclaredFields()) System.out.println(f);
            for (Method m : cls.getDeclaredMethods()) System.out.println(m);
        } catch (Exception e) {
            System.out.println("Class not found");
        }
        sc.close();
    }
}
