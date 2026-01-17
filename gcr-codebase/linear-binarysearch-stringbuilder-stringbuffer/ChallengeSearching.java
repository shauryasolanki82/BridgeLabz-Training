package searching;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ChallengeSearching {

    public static void main(String[] args) {
        int[] data = {3, 4, -1, 1, 7, 8, 2, 0, 10};
        int target = 7;
        int missing = findFirstMissingPositive(data);
        System.out.println("First Missing Positive Integer: " + missing);
        Arrays.sort(data); 
        int targetIndex = binarySearch(data, target);
        if (targetIndex != -1) {
            System.out.println("Target " + target + " found at index: " + targetIndex);
        } else {
            System.out.println("Target " + target + " not found.");
        }
    }
    
    public static int findFirstMissingPositive(int[] nums) {
        Set<Integer> presentNumbers = new HashSet<>();
        for (int num : nums) {
            presentNumbers.add(num);
        }
        int missing = 1;
        while (presentNumbers.contains(missing)) {
            missing++;
        }
        return missing;
    }

    public static int binarySearch(int[] sortedArr, int target) {
        int left = 0;
        int right = sortedArr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sortedArr[mid] == target) {
                return mid; 
            } 
            else if (sortedArr[mid] < target) {
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
