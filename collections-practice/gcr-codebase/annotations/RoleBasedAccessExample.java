package annotations;
import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface RoleAllowed {
    String value();
}

@RoleAllowed("ADMIN")
class AdminService {
    void deleteUser() {
        System.out.println("User deleted");
    }
}

public class RoleBasedAccessExample {
    static void invokeIfAllowed(Object obj, String role, String method) throws Exception {
        RoleAllowed ra = obj.getClass().getAnnotation(RoleAllowed.class);
        if (ra != null && !ra.value().equals(role)) {
            System.out.println("Access Denied!");
            return;
        }
        Method m = obj.getClass().getDeclaredMethod(method);
        m.invoke(obj);
    }

    public static void main(String[] args) throws Exception {
        AdminService service = new AdminService();
        invokeIfAllowed(service, "USER", "deleteUser");
        invokeIfAllowed(service, "ADMIN", "deleteUser");
    }
}
