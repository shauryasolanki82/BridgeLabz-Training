package annotations;
import java.util.*;

public class SuppressWarningsExample {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("Hello");
        list.add(10);
        for (Object o : list) System.out.println(o);
    }
}
