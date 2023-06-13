import java.util.*;

public class ThreeSum_15 {
    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(new Solution().threeSum(new int[]{-2, 0, 1, 1, 2}));
    }

    private static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            var res = new HashSet<List<Integer>>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        res.add(List.of(nums[i], nums[j], nums[k]));
                        j++;
                        k--;
                    } else if (sum < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
            return res.stream().toList();
        }
    }
}
