package collections;

import java.util.ArrayList;
import java.util.List;

public class RotateList {
    public static List<Integer> rotateList(List<Integer> list, int rotateBy) {
        List<Integer> rotatedList = new ArrayList<>();
        int size = list.size();
        rotateBy = rotateBy % size;
        for (int i = rotateBy; i < size; i++) {
            rotatedList.add(list.get(i));
        }
        for (int i = 0; i < rotateBy; i++) {
            rotatedList.add(list.get(i));
        }
        return rotatedList;
    }
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);
        int rotateBy = 2;
        System.out.println("Original List : " + numbers);
        System.out.println("Rotated List  : " + rotateList(numbers, rotateBy));
    }
}
