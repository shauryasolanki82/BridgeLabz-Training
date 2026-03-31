package reflections;
import java.lang.reflect.*;

interface Greeting {
    String sayHello(String name);
}

class GreetingImpl implements Greeting {
    public String sayHello(String name) {
        return "Hello " + name;
    }
}

public class LoggingProxy {
    public static void main(String[] args) {
        Greeting target = new GreetingImpl();
        Greeting proxy = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class[]{Greeting.class},
                (p, method, methodArgs) -> {
                    System.out.println(method.getName());
                    return method.invoke(target, methodArgs);
                }
        );
        System.out.println(proxy.sayHello("Saurav"));
    }
}
