package searching;

public class PeakElement {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        int peakIndex = findPeakElement(nums);
        System.out.println("Peak element found at index: " + peakIndex);
        if (peakIndex != -1) {
            System.out.println("Value: " + nums[peakIndex]);
        }
    }

    public static int findPeakElement(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        if (arr.length == 1) return 0;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean greaterThanPrev = (mid == 0 || arr[mid] > arr[mid - 1]);
            boolean greaterThanNext = (mid == arr.length - 1 || arr[mid] > arr[mid + 1]);
            if (greaterThanPrev && greaterThanNext) {
                return mid;
            }
            if (mid > 0 && arr[mid - 1] > arr[mid]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return -1; 
    }
}