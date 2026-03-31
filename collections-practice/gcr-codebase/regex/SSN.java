package regex;

import java.util.regex.*;

public class SSN {
    public static void main(String[] args) {

        String text1 = "My SSN is 123-45-6789.";
        String text2 = "My SSN is 123456789.";

        validateSSN(text1);
        validateSSN(text2);
    }

    static void validateSSN(String text) {
        String regex = "\\b\\d{3}-\\d{2}-\\d{4}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            System.out.println(matcher.group() + " is valid");
        } else {
            System.out.println("SSN is invalid");
        }
    }
}

