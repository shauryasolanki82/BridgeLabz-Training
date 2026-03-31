package functional_interface;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface DateFormatUtility {
	 String INVOICE_FORMAT = "dd-MM-yyyy";
	 String READABLE_FORMAT = "MMMM dd, yyyy";

	 static String format(LocalDate date, String pattern) {
		 if (date == null || pattern == null) {
			 throw new IllegalArgumentException("Invalid input");
	     }

	     return date.format(DateTimeFormatter.ofPattern(pattern));
	 }
}
