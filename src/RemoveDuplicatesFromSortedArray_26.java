import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray_26 {
    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates(new int[]{1, 1, 2}));
    }

    private static class Solution {
        public int removeDuplicates(int[] nums) {
            int repeating = nums[0];
            int length = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != repeating) {
                    repeating = nums[i];
                    nums[length] = nums[i];
                    length++;
                }
            }
            System.out.println(Arrays.toString(nums));
            return length;
        }
    }
}
