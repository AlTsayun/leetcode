public class FactorialTrailingZeroes_172 {
    public static void main(String[] args) {
        System.out.println(new Solution().trailingZeroes(3));
        System.out.println(new Solution().trailingZeroes(5));
        System.out.println(new Solution().trailingZeroes(0));
    }
    private static class Solution {
        public int trailingZeroes(int n) {
            int acc = 0;
            for (int i = 5; i < n + 1; i++) {
                int cur = i;
                while (cur % 5 == 0) {
                    cur /= 5;
                    acc++;
                }
            }
            return acc;
        }
    }
}
