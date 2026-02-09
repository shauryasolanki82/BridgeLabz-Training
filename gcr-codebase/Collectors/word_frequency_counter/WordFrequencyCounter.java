package word_frequency_counter;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordFrequencyCounter {
    public static void main(String[] args) {

        String paragraph = "Java is simple and Java is powerful and Java is popular";

        Map<String, Integer> wordCount = Arrays.stream(paragraph.toLowerCase().replaceAll("[^a-z ]", "").split("\\s+")).collect(Collectors.toMap(Function.identity(),word -> 1, Integer::sum));
        wordCount.forEach((word, count) ->System.out.println(word + " : " + count));
    }
}

