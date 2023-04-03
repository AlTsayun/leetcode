public class MaximumSubarray_53 {
    static class Solution {
        public int maxSubArray(int[] nums) {
            int maxSum = nums[0];
            int localMaxSum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                localMaxSum = Math.max(localMaxSum + nums[i], nums[i]);
                maxSum = Math.max(localMaxSum, maxSum);
            }
            return maxSum;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(new Solution().maxSubArray(new int[] {-1}));
        System.out.println(new Solution().maxSubArray(new int[] {1, -3, 2, 1, -1}));
    }
}
