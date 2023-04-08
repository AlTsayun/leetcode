import java.util.Arrays;

public class NthTribonacciNumber_1137 {
    private static class Solution {
        static final int[] memo = new int[37];
        static {
            Arrays.fill(memo, -1);
            memo[0] = 0;
            memo[1] = 1;
            memo[2] = 1;
        }
        public int tribonacci(int n) {
            if (memo[n] == -1) {
                memo[n] = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
            }
            return memo[n];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().tribonacci(1));
        System.out.println(new Solution().tribonacci(25));
        System.out.println(new Solution().tribonacci(30));
    }
}
