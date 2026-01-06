import java.util.*;

class Solution {
    public int reverse(int x) {
        long r = 0, rem = 0;

        while (x != 0) {
            r = x % 10;
            rem = rem * 10 + r;
            x = x / 10;
        }

        if (Math.pow(-2, 31) > rem || rem > (Math.pow(2, 31) - 1)) {
            return 0;
        }

        return (int) rem;
    }
}

public class ReverseInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input integer
        int x = sc.nextInt();

        Solution sol = new Solution();
        int result = sol.reverse(x);

        // Output reversed integer
        System.out.println(result);

        sc.close();
    }
}
