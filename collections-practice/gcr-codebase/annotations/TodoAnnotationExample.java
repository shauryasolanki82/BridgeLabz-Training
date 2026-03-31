package annotations;
import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class Project {
    @Todo(task = "Add payment gateway", assignedTo = "Saurav", priority = "HIGH")
    void payment() {}
    @Todo(task = "Improve UI", assignedTo = "Aman")
    void ui() {}
    void done() {}
}

public class TodoAnnotationExample {
    public static void main(String[] args) {
        for (Method m : Project.class.getDeclaredMethods()) {
            Todo t = m.getAnnotation(Todo.class);
            if (t != null) System.out.println(m.getName() + " | " + t.task() + " | " + t.assignedTo() + " | " + t.priority());
        }
    }
}
