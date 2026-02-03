package reflections;
import java.lang.reflect.*;
import java.util.*;

class MathOperations {
    public int add(int a, int b) { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
}

public class DynamicMethodInvocation {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String methodName = sc.nextLine().trim();
        int a = Integer.parseInt(sc.nextLine().trim());
        int b = Integer.parseInt(sc.nextLine().trim());
        MathOperations ops = new MathOperations();
        Method m = ops.getClass().getMethod(methodName, int.class, int.class);
        System.out.println(m.invoke(ops, a, b));
        sc.close();
    }
}
