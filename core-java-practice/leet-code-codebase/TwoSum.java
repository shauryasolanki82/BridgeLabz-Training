import java.util.Scanner;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ar = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ar[0] = i;
                    ar[1] = j;
                    return ar; // return as soon as pair is found
                }
            }
        }
        return ar;
    }
}

public class TwoSum {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        // Input array elements
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Input target
        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        // Call Solution
        Solution sol = new Solution();
        int[] result = sol.twoSum(nums, target);

        // Output result
        System.out.println("Indices: " + result[0] + " " + result[1]);

        sc.close();
    }
}
