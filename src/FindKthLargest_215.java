import java.util.ArrayList;

public class FindKthLargest_215 {
    public static void main(String[] args) {
        System.out.println(new Solution().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(new Solution().findKthLargest(new int[]{1, 2}, 2));
        System.out.println(new Solution().findKthLargest(new int[]{2, 1}, 2));
    }

    private static class Solution {
        public int findKthLargest(int[] nums, int k) {
            return quickSelect(nums, 0, nums.length, k);
        }
        private int quickSelect(int[] nums, int from, int to, int k) {
            int left = from;
            for (int i = from + 1; i < to; i++) {
                // pivot is the first element
                if (nums[i] <= nums[from]) {
                    left++;
                    if (left != i) {
                        int tmp = nums[left];
                        nums[left] = nums[i];
                        nums[i] = tmp;
                    }
                }
            }
            // swap pivot with last element from left (smaller) part
            int tmp = nums[from];
            nums[from] = nums[left];
            nums[left] = tmp;
            // the correct position of pivot
            int pivot = left;
            var pivotNumberFromEnd = to - pivot;
            if (pivotNumberFromEnd == k) {
                return nums[pivot];
            }
            if (pivotNumberFromEnd > k) {
                return quickSelect(nums, pivot + 1, to, k);
            } else {
                return quickSelect(nums, from, pivot, k - pivotNumberFromEnd);
            }
        }
    }
}
