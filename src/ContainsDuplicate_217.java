import java.util.HashSet;

public class ContainsDuplicate_217 {
    private static class Solution {

        public boolean containsDuplicate(int[] nums) {
            var set = new HashSet<Integer>();
            for (int num : nums) {
                if (set.contains(num)) {
                    return true;
                }
                set.add(num);
            }
            return false;

        }
    }
    public static void main(String[] args) {
        System.out.println(new Solution().containsDuplicate(new int[]{1, 2, 3, 4}));
    }
}