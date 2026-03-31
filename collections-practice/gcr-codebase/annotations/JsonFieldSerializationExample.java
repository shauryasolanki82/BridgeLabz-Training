package annotations;
import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class JsonUser {
    @JsonField(name = "user_name")
    private final String username;
    @JsonField(name = "user_age")
    private final int age;

    JsonUser(String username, int age) {
        this.username = username;
        this.age = age;
    }
}

public class JsonFieldSerializationExample {
    static String toJson(Object obj) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            Field[] fields = obj.getClass().getDeclaredFields();
            int added = 0;
            for (Field f : fields) {
                JsonField jf = f.getAnnotation(JsonField.class);
                if (jf == null) continue;
                f.setAccessible(true);
                Object val = f.get(obj);
                if (added++ > 0) sb.append(",");
                sb.append("\"").append(jf.name()).append("\":");
                if (val == null) sb.append("null");
                else if (val instanceof String) sb.append("\"").append(val).append("\"");
                else sb.append(val);
            }
            sb.append("}");
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(toJson(new JsonUser("Saurav", 21)));
    }
}
