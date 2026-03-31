package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyOfElements {

    public static Map<String, Integer> findFrequency(List<String> list) {

        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String item : list) {
            if (frequencyMap.containsKey(item)) {
                frequencyMap.put(item, frequencyMap.get(item) + 1);
            } else {
                frequencyMap.put(item, 1);
            }
        }
        return frequencyMap;
    }
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("apple");
        fruits.add("orange");
        System.out.println("Input List : " + fruits);
        Map<String, Integer> result = findFrequency(fruits);
        System.out.println("Frequency Map : " + result);
    }
}
