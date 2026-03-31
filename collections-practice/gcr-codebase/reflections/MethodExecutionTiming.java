package reflections;
import java.lang.reflect.*;

class Work {
    public void fast() {
        for (int i = 0; i < 1000000; i++) {}
    }
    public void slow() {
        for (int i = 0; i < 20000000; i++) {}
    }
}

public class MethodExecutionTiming {
    static void time(Object obj, String methodName) throws Exception {
        Method m = obj.getClass().getMethod(methodName);
        long start = System.nanoTime();
        m.invoke(obj);
        long end = System.nanoTime();
        System.out.println(methodName + " " + (end - start));
    }

    public static void main(String[] args) throws Exception {
        Work w = new Work();
        time(w, "fast");
        time(w, "slow");
    }
}
