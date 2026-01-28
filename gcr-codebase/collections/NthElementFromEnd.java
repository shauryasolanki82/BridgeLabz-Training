package collections;

import java.util.LinkedList;

public class NthElementFromEnd {
    public static String findNthFromEnd(LinkedList<String> list, int n) {
        if (list == null || list.isEmpty() || n <= 0) {
            return null;
        }
        int firstPointer = 0;
        int secondPointer = 0;
        for (int i = 0; i < n; i++) {
            if (firstPointer == list.size()) {
                return null;
            }
            firstPointer++;
        }
        while (firstPointer < list.size()) {
            firstPointer++;
            secondPointer++;
        }
        return list.get(secondPointer);
    }
    public static void main(String[] args) {
        LinkedList<String> letters = new LinkedList<>();
        letters.add("A");
        letters.add("B");
        letters.add("C");
        letters.add("D");
        letters.add("E");
        int n = 2;
        System.out.println("LinkedList : " + letters);
        System.out.println("Nth element from end : " + findNthFromEnd(letters, n));
    }
}
