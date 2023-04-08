public class MinimizeMaximumOfArray_2439 {
    private static class Solution {
        public int minimizeArrayValue(int[] nums) {
            long sumOfAll = 0;
            long minMaximum = 0;

            for (int i = 0; i < nums.length; i++) {
                sumOfAll += nums[i];
                minMaximum = Math.max(minMaximum, ceil(sumOfAll, i + 1));
            }
            return (int) minMaximum;
        }

        private long ceil(long number, long divisor) {
            return (number + divisor - 1) / divisor;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minimizeArrayValue(new int[]{3, 7, 1, 6}));
    }
}
