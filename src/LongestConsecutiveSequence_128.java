import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutiveSequence_128 {
    public static void main(String[] args) {
        System.out.println(new Solution().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    private static class Solution {
        public int longestConsecutive(int[] nums) {
            var set = new HashSet<Integer>();
            for (var num : nums){
                set.add(num);
            }
            int longest = 0;
            for (var num : set) {
                if (!set.contains(num - 1)) {
                    int current = 1;
                    while (set.contains(num + 1)) {
                        num++;
                        current++;
                    }
                    longest = Math.max(longest, current);
                }
            }
            return longest;
        }
    }
}
