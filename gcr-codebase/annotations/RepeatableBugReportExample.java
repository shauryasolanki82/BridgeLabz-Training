package annotations;
import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

class AppService {
    @BugReport(description = "Null pointer in login")
    @BugReport(description = "UI crash on submit")
    void login() {}
}

public class RepeatableBugReportExample {
    public static void main(String[] args) throws Exception {
        Method m = AppService.class.getDeclaredMethod("login");
        BugReport[] reports = m.getAnnotationsByType(BugReport.class);
        for (BugReport r : reports) System.out.println(r.description());
    }
}
