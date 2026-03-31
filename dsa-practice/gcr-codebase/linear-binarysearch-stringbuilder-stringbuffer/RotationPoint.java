package searching;

public class RotationPoint {

    public static void main(String[] args) {
        int[] rotatedArray = {4, 5, 6, 7, 0, 1, 2};
        int minElement = findRotationPointValue(rotatedArray);
        System.out.println("The rotation point is: " + minElement);
    }

    public static int findRotationPointValue(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return arr[left];
    }
}