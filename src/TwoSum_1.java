import java.util.Arrays;
import java.util.HashMap;

public class TwoSum_1 {
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            var map = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums.length; i++) {
                var otherSummand = target - nums[i];
                var previousSummandIndex = map.get(otherSummand);
                if (previousSummandIndex != null) {
                    return new int[] {previousSummandIndex, i};
                }
                map.put(nums[i], i);
            }
            throw new RuntimeException();
        }
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[] {-2,1,-3,4,-1,2,1,-5,4}, 6)));
        System.out.println(Arrays.toString(new Solution().twoSum(new int[] {-1, 0, 3, 4}, -1)));
        System.out.println(Arrays.toString(new Solution().twoSum(new int[] {1, -3, 2, 1, -1}, -4)));
    }
}
