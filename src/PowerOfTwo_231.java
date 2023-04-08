public class PowerOfTwo_231 {
    private static class Solution {
        public boolean isPowerOfTwo(int n) {
            int acc = 0;
            while (n > 0) {
                acc += n & 1;
                n = n >> 1;
            }
            return acc == 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfTwo(0));
        System.out.println(new Solution().isPowerOfTwo(1));
        System.out.println(new Solution().isPowerOfTwo(2));
        System.out.println(new Solution().isPowerOfTwo(3));
        System.out.println(new Solution().isPowerOfTwo(4));
        System.out.println(new Solution().isPowerOfTwo(2049));
    }
}
