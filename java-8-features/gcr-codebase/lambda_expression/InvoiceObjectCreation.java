package lambda_expression;
import java.util.*;
import java.util.function.Function;

public class InvoiceObjectCreation {
	static class Invoice {
		String id;

		Invoice(String id) {
			this.id = id;
		}

		public String toString() {
			return "Invoice:" + id;
		}
	}

	public static void main(String[] args) {
		List<String> transactions = Arrays.asList("T1001", "T1002", "T1003");
		Function<String, Invoice> creator = Invoice::new;
		transactions.stream().map(creator).forEach(System.out::println);
	}
}