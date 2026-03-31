package reflections;
import java.lang.reflect.*;

class Employee {
    String name;
    int id;
    boolean active;
    Employee(String name, int id, boolean active) {
        this.name = name;
        this.id = id;
        this.active = active;
    }
}

public class JsonRepresentation {
    static String toJson(Object obj) {
        try {
            Class<?> cls = obj.getClass();
            Field[] fields = cls.getDeclaredFields();
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            for (int i = 0; i < fields.length; i++) {
                Field f = fields[i];
                f.setAccessible(true);
                Object val = f.get(obj);
                sb.append("\"").append(f.getName()).append("\":");
                if (val == null) sb.append("null");
                else if (val instanceof String) sb.append("\"").append(val).append("\"");
                else sb.append(val);
                if (i != fields.length - 1) sb.append(",");
            }
            sb.append("}");
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Employee e = new Employee("Saurav", 7, true);
        System.out.println(toJson(e));
    }
}
