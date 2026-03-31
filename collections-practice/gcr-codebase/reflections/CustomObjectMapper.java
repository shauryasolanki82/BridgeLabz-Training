package reflections;
import java.lang.reflect.*;
import java.util.*;

public class CustomObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            T obj = clazz.getDeclaredConstructor().newInstance();
            for (Map.Entry<String, Object> e : properties.entrySet()) {
                try {
                    Field f = clazz.getDeclaredField(e.getKey());
                    f.setAccessible(true);
                    f.set(obj, e.getValue());
                } catch (NoSuchFieldException ignored) {}
            }
            return obj;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static class User {
        String name;
        int age;
        public String toString() { return name + " " + age; }
    }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Saurav");
        map.put("age", 21);
        System.out.println(toObject(User.class, map));
    }
}
