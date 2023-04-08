import java.util.Arrays;

public class RotateArray_189 {
    private static class Solution {
        public void rotate(int[] nums, int k) {
            k = k % nums.length;
            reverse(nums, 0, nums.length);
            reverse(nums, 0, k);
            reverse(nums, k, nums.length);
        }

        private void reverse(int[] nums, int fromInclusive, int toExclusive) {
            int tmp;
            int j = toExclusive - 1;
            for (int i = fromInclusive; i < (toExclusive + fromInclusive) / 2; i++) {
                tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        var nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        new RotateArray_189.Solution().rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{-1};
        new RotateArray_189.Solution().rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
