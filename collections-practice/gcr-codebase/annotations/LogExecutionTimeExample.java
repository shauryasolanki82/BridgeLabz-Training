package annotations;
import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

class Worker {
    @LogExecutionTime
    void fast() {
        for (int i = 0; i < 1000000; i++) {}
    }
    @LogExecutionTime
    void slow() {
        for (int i = 0; i < 20000000; i++) {}
    }
}

public class LogExecutionTimeExample {
    static void run(Object obj, Method m) throws Exception {
        long start = System.nanoTime();
        m.invoke(obj);
        long end = System.nanoTime();
        System.out.println(m.getName() + " " + (end - start));
    }

    public static void main(String[] args) throws Exception {
        Worker w = new Worker();
        for (Method m : Worker.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(LogExecutionTime.class)) run(w, m);
        }
    }
}
