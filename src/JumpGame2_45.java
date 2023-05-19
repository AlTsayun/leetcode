import java.util.Arrays;

public class JumpGame2_45 {
    public static void main(String[] args) {
        System.out.println(new Solution().jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new Solution().jump(new int[]{2, 3, 0, 1, 4}));
    }

    private static class Solution {

        public int jump(int[] nums) {
            int[] dp = new int[nums.length];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < Math.min(i + nums[i] + 1, nums.length); j++) {
                    dp[j] = Math.min(dp[j], dp[i] + 1);
                }
            }
            return dp[nums.length - 1];
        }
    }
}
