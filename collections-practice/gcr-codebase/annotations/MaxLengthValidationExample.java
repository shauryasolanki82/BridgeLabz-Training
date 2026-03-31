package annotations;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    private final String username;

    User(String username) {
        int limit = 10;
        try {
            limit = User.class.getDeclaredField("username").getAnnotation(MaxLength.class).value();
        } catch (Exception ignored) {}
        if (username == null || username.length() > limit) throw new IllegalArgumentException("Username too long");
        this.username = username;
    }

    public String toString() {
        return username;
    }
}

public class MaxLengthValidationExample {
    public static void main(String[] args) {
        System.out.println(new User("saurav"));
    }
}
