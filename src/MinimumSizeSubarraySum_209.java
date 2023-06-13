public class MinimumSizeSubarraySum_209 {
    public static void main(String[] args) {
        System.out.println(new Solution().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    private static class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int from = 0;
            int to = 0;
            int sum = nums[0];
            int minLength = 0;
            while (to < nums.length) {
                if (sum < target) {
                    to++;
                    if (to < nums.length) {
                        sum += nums[to];
                    }
                } else {
                    if (minLength == 0) {
                        minLength = to - from + 1;
                    } else {
                        minLength = Math.min(minLength, to - from + 1);
                    }
                    sum -= nums[from];
                    from++;
                }
            }
            return minLength;
        }
    }
}
