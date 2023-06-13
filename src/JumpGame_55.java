public class JumpGame_55 {
    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new Solution().canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(new Solution().canJump(new int[]{0,2,3}));
    }

    private static class Solution {
        public boolean canJump(int[] nums) {
            int aim = nums.length - 1;
            for (int i = nums.length - 2; i > -1; i--) {
               if (aim - i <= nums[i]) {
                   aim = i;
               }
            }
            return aim == 0;
        }
    }
    private static class DPSolution {
        public boolean canJump(int[] nums) {
            var dp = new boolean[nums.length];
            dp[0] = true;
            for (int i = 0; i < nums.length && dp[i]; i++) {
                int element = nums[i];
                for (int j = i + 1; j < Math.min(i + element + 1, dp.length); j++) {
                    dp[j] = true;
                }
            }
            return dp[dp.length - 1];
        }
    }
}
