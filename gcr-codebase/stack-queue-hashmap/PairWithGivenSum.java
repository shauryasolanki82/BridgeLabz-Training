import java.util.HashMap;
public class PairWithGivenSum {
    public static boolean hasPairWithSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            int complement = target - num;

            if (map.containsKey(complement)) {
                System.out.println("Pair found: " + num + " + " + complement + " = " + target);
                return true;
            }

            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {8, 7, 2, 5, 3, 1};
        int target = 10;

        boolean result = hasPairWithSum(arr, target);
        System.out.println("Pair exists: " + result);
    }
}
