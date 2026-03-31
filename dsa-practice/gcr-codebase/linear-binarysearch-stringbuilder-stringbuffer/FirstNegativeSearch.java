package searching;

public class FirstNegativeSearch {

    public static void main(String[] args) {
        int[] numbers = {12, 5, 0, 8, -3, 10, -7};
        int index = findFirstNegativeIndex(numbers);
        if (index != -1) {
            System.out.println("First negative number found at index: " + index);
            System.out.println("The number is: " + numbers[index]);
        } else {
            System.out.println("No negative number found in the array.");
        }
    }
    public static int findFirstNegativeIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }
}
