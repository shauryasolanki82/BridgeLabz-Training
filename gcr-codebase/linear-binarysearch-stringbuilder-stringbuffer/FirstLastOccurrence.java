package searching;

public class FirstLastOccurrence {

    public static void main(String[] args) {
        int[] nums = {2, 5, 5, 5, 6, 6, 8, 9, 9, 9};
        int target = 5;
        int[] result = findFirstAndLast(nums, target);
        System.out.println("Target: " + target);
        System.out.println("First Occurrence Index: " + result[0]);
        System.out.println("Last Occurrence Index:  " + result[1]);
    }

    public static int[] findFirstAndLast(int[] nums, int target) {
        int first = findOccurrence(nums, target, true);  
        int last  = findOccurrence(nums, target, false);
        return new int[] {first, last};
    }

    private static int findOccurrence(int[] nums, int target, boolean findFirst) {
        int left = 0;
        int right = nums.length - 1;
        int resultIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                resultIndex = mid; 
                if (findFirst) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } 
            else if (target < nums[mid]) {
                right = mid - 1;
            } 
            else {
                left = mid + 1;
            }
        }
        return resultIndex;
    }
}
