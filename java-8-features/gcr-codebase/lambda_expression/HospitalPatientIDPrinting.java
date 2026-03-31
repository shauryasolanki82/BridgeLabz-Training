package lambda_expression;
import java.util.*;

public class HospitalPatientIDPrinting {
	public static void main(String[] args) {
		List<String> ids = Arrays.asList("P101", "P102", "P103", "P104");
		ids.forEach(System.out::println);
	}
}