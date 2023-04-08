import java.util.Arrays;

public class FibonacciNumber_509 {
    private static class Solution {
        static final int[] memo = new int[31];
        static {
            Arrays.fill(memo, -1);
            memo[0] = 0;
            memo[1] = 1;
            memo[2] = 1;
        }
        public int fib(int n) {
            if (memo[n] == -1) {
                memo[n] = fib(n - 1) + fib(n - 2);
            }
            return memo[n];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fib(1));
        System.out.println(new Solution().fib(30));
    }
}
