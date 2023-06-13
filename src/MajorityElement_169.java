public class MajorityElement_169 {
    public static void main(String[] args) {
        System.out.println(new Solution().majorityElement(new int[]{3,2,3}));
        System.out.println(new Solution().majorityElement(new int[]{2,2,1,1,1,2,2}));
        System.out.println(new Solution().majorityElement(new int[]{3,3,4}));
    }

    private static class Solution {
        public int majorityElement(int[] nums) {
            int candidate = nums[0];
            int count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (count == 0) {
                    candidate = nums[i];
                }
                if (nums[i] == candidate) {
                    count++;
                } else {
                    count--;
                }
            }
            return candidate;
        }
    }
}
