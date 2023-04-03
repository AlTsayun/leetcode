public class NumberOfOneBits_191 {
    static class Solution {    // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int acc = 0;
            while (n != 0) {
                acc += n & 1;
                n = n >>> 1;
            }
            return acc;
        }
    }
    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight(1));
        System.out.println(new Solution().hammingWeight(2));
        System.out.println(new Solution().hammingWeight(3));
        System.out.println(new Solution().hammingWeight(4));
        System.out.println(new Solution().hammingWeight(5));
    }
}