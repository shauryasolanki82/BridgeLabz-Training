package annotations;
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

class HeavyService {
    @CacheResult
    public long fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }
}

public class CacheResultExample {
    static class CacheProxy {
        private final Object target;
        private final Map<String, Object> cache = new HashMap<>();

        CacheProxy(Object target) {
            this.target = target;
        }

        Object call(String methodName, Object... args) throws Exception {
            Method m = null;
            for (Method mm : target.getClass().getMethods()) {
                if (mm.getName().equals(methodName) && mm.getParameterCount() == args.length) {
                    m = mm;
                    break;
                }
            }
            if (m == null) throw new NoSuchMethodException(methodName);
            boolean cacheable = m.isAnnotationPresent(CacheResult.class);
            String key = methodName + Arrays.toString(args);
            if (cacheable && cache.containsKey(key)) return cache.get(key);
            Object result = m.invoke(target, args);
            if (cacheable) cache.put(key, result);
            return result;
        }
    }

    public static void main(String[] args) throws Exception {
        CacheProxy proxy = new CacheProxy(new HeavyService());
        System.out.println(proxy.call("fib", 35));
        System.out.println(proxy.call("fib", 35));
    }
}
