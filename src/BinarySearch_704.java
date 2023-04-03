public class BinarySearch_704 {
    static class Solution {
        public int search(int[] nums, int target) {
            // return recursiveSearch(nums, 0, nums.length, target);
            return iterativeSearch(nums, target);
        }

        private int recursiveSearch(int[] nums, int start, int end, int target) {
            if (start == end - 1) {
                return nums[start] == target ? start : -1;
            }
            int middle = (start + end) / 2;
            if (target >= nums[middle]) {
                return recursiveSearch(nums, middle, end, target);
            } else {
                return recursiveSearch(nums, start, middle, target);
            }
        }

        private int iterativeSearch(int[] nums, int target) {
            // inclusive
            int start = 0;
            // exclusive
            int end = nums.length;
            while (start != end - 1) {
                int middle = (start + end) / 2;
                if (target >= nums[middle]) {
                    start = middle;
                } else {
                    end = middle;
                }
            }
            return nums[start] == target ? start : -1;
        }
    }
    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{1, 2, 3, 4, 7, 8}, 7));
        System.out.println(new Solution().search(new int[]{-1, 5, 100}, -1));
        System.out.println(new Solution().search(new int[]{15, 19}, 19));
        System.out.println(new Solution().search(new int[]{0}, 0));
    }
}