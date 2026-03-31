package reflections;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}

class Engine {
    String start() { return "Engine started"; }
}

class Car {
    @Inject
    private Engine engine;
    String drive() { return engine.start() + " and car is driving"; }
}

public class SimpleDIContainer {
    static class Container {
        private final Map<Class<?>, Object> beans = new HashMap<>();

        <T> T getBean(Class<T> clazz) {
            try {
                Object existing = beans.get(clazz);
                if (existing != null) return clazz.cast(existing);
                T obj = clazz.getDeclaredConstructor().newInstance();
                beans.put(clazz, obj);
                for (Field f : clazz.getDeclaredFields()) {
                    if (!f.isAnnotationPresent(Inject.class)) continue;
                    f.setAccessible(true);
                    Object dep = getBean(f.getType());
                    f.set(obj, dep);
                }
                return obj;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Container c = new Container();
        Car car = c.getBean(Car.class);
        System.out.println(car.drive());
    }
}
