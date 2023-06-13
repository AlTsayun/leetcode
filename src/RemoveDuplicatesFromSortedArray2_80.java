import java.text.spi.BreakIteratorProvider;
import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray2_80 {
    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates(new int[]{1, 1, 1, 2}));
        System.out.println(new Solution().removeDuplicates(new int[]{1, 2, 2, 2}));
        System.out.println(new Solution().removeDuplicates(new int[]{1, 2, 2, 2, 3}));
    }

    private static class Solution {
        public int removeDuplicates(int[] nums) {
            int length = 0;
            int count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[length]) {
                    count++;
                } else {
                    count = 1;
                }
                if (nums[i] != nums[length] || count <= 2) {
                    length++;
                    nums[length] = nums[i];
                }
            }
            return length + 1;
        }
    }
}
