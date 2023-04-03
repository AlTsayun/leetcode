public class SingleNumber_136 {
    static class Solution {
        public int singleNumber(int[] nums) {
            int acc = 0;
            for (int num : nums) {
                acc ^= num;
            }
            return acc;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().singleNumber(new int[] {4,1,2,1,2}));
    }
}
