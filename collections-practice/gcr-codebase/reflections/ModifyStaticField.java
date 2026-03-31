package reflections;
import java.lang.reflect.*;

class Configuration {
    private static String API_KEY = "OLD_KEY";
    static String getApiKey() { return API_KEY; }
}

public class ModifyStaticField {
    public static void main(String[] args) throws Exception {
        Field f = Configuration.class.getDeclaredField("API_KEY");
        f.setAccessible(true);
        f.set(null, "NEW_KEY");
        System.out.println(Configuration.getApiKey());
    }
}
