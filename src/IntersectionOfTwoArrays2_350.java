import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class IntersectionOfTwoArrays2_350 {
    private static class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            var map = new HashMap<Integer, Integer>(Math.max(nums1.length, nums2.length));
            var intersection = new ArrayList<Integer>(Math.min(nums1.length, nums2.length));
            for (int num : nums1) {
                map.compute(num, (number, occasions) -> occasions == null ? 1 : occasions + 1);
            }

            for (int num : nums2) {
                map.computeIfPresent(num, (number, occasions) -> {
                    intersection.add(number);
                    return occasions - 1 == 0 ? null : occasions - 1;
                });
            }

            return intersection.stream().mapToInt(Integer::intValue).toArray();
        }
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().intersect(new int[] {-2,1,-3,4,-1,2,1,-5,4}, new int[] {-3, 4, -1, 1, 1})));
        System.out.println(Arrays.toString(new Solution().intersect(new int[] {-1, 0, 3, 4}, new int[] {})));
        System.out.println(Arrays.toString(new Solution().intersect(new int[] {1, -3, 2, 1, -1}, new int[] {-1})));
    }
}
