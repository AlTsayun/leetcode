import java.util.Arrays;

public class NumberOfLongestIncreasingSubstring_673 {
    public static void main(String[] args) {
        System.out.println(new Solution().findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(new Solution().findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));
        System.out.println(new Solution().findNumberOfLIS(new int[]{1}));
        System.out.println(new Solution().findNumberOfLIS(new int[]{1, 2, 4, 3, 5, 4, 7, 2}));
    }

    private static class Solution {
        public int findNumberOfLIS(int[] nums) {
            var lengths = new int[nums.length];
            lengths[lengths.length - 1] = 1;
            Arrays.fill(lengths, 1);
            var lisCounts = new int[nums.length];
            lisCounts[lisCounts.length - 1] = 1;
            Arrays.fill(lisCounts, 1);

            int maxLength = 1;
            for (int i = nums.length - 2; i > -1; i--) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] > nums[i]) {
                        if (lengths[j] + 1 == lengths[i]) {
                            lisCounts[i] += lisCounts[j];
                        }
                        if (lengths[j] + 1 > lengths[i]) {
                            lengths[i] = lengths[j] + 1;
                            lisCounts[i] = lisCounts[j];
                        }
                    }
                    maxLength = Math.max(maxLength, lengths[i]);
                }
            }
            int count = 0;
            for (int i = 0; i < lisCounts.length; i++) {
                if (lengths[i] == maxLength) {
                    count += lisCounts[i];
                }
            }
            return count;
        }
    }
}
