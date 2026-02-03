package reflections;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name();
}

@Author(name = "Author Name")
class Book {}

public class RetrieveAnnotationRuntime {
    public static void main(String[] args) {
        Author a = Book.class.getAnnotation(Author.class);
        System.out.println(a == null ? "" : a.name());
    }
}
