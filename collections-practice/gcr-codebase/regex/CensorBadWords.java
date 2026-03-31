package regex;

import java.util.regex.*;

public class CensorBadWords {
    public static void main(String[] args) {

        String text = "This is a damn bad example with some stupid words.";

        String[] badWords = {"damn", "stupid"};

        // damn|stupid
        String regex = "\\b(" + String.join("|", badWords) + ")\\b";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        String censoredText = matcher.replaceAll("****");

        System.out.println(censoredText);
    }
}