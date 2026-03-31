package lambda_expression;
import java.util.*;
import java.util.function.Predicate;

public class NotificationFiltering {
	public static void main(String[] args) {
		List<String> alerts = Arrays.asList("Critical: ICU", "Info: Appointment", "Warning: BP High",
				"Critical: Surgery");
		Predicate<String> critical = a -> a.startsWith("Critical");
		alerts.stream().filter(critical).forEach(System.out::println);
	}
}