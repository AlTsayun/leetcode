import java.util.Arrays;

public class MoveZeroes_283 {
    static class Solution {
        public void moveZeroes(int[] nums) {
            int step = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    step++;
                } else {
                    nums[i - step] = nums[i];
                }
            }
            for (int i = nums.length - step; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        var nums = new int[]{1, 0, 2, 3, 0, 4, 5, 6, 7};
        new MoveZeroes_283.Solution().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{-1};
        new MoveZeroes_283.Solution().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{0};
        new MoveZeroes_283.Solution().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
