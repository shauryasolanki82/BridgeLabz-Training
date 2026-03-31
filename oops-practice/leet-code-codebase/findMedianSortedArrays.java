import java.util.*;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        double ans = 0.0000;

        int arr[] = new int[n + m];

        for (int i = 0; i < n; i++) {
            arr[i] = nums1[i];
        }

        for (int i = n; i < n + m; i++) {
            arr[i] = nums2[i - n];
        }

        Arrays.sort(arr);

        if (arr.length % 2 != 0) {
            int k = arr.length / 2;
            ans = arr[k];
            return ans;
        } else {
            int k = arr.length / 2;
            double a = arr[k];
            double b = arr[k - 1];
            ans = (a + b) / 2;
            return ans;
        }
    }
}

public class findMedianSortedArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for first array
        int n = sc.nextInt();
        int[] nums1 = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = sc.nextInt();
        }

        // Input for second array
        int m = sc.nextInt();
        int[] nums2 = new int[m];
        for (int i = 0; i < m; i++) {
            nums2[i] = sc.nextInt();
        }

        Solution sol = new Solution();
        double result = sol.findMedianSortedArrays(nums1, nums2);

        System.out.println(result);

        sc.close();
    }
}
