package reflections;
import java.lang.reflect.*;

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class PrivateMethodInvoke {
    public static void main(String[] args) throws Exception {
        Calculator c = new Calculator();
        Method m = c.getClass().getDeclaredMethod("multiply", int.class, int.class);
        m.setAccessible(true);
        System.out.println(m.invoke(c, 10, 5));
    }
}
