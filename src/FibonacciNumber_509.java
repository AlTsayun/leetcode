public class FibonacciNumber_509 {
    static class Solution {
        static final int[] memo = new int[30];
        static {
            memo[0] = 1;
            memo[1] = 1;
        }
        public int fib(int n) {
            if (memo[n - 1] == 0) {
                memo[n - 1] = fib(n - 1) + fib(n - 2);
            }
            return memo[n - 1];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fib(1));
        System.out.println(new Solution().fib(30));
    }
}
