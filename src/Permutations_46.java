import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations_46 {
    static class Solution {

        private int[] nums;
        private ArrayList<List<Integer>> result;
        private boolean[] canBeSelected;

        public List<List<Integer>> permute(int[] nums) {
            this.nums = nums;
            result = new ArrayList<>();
            canBeSelected = new boolean[nums.length];
            Arrays.fill(canBeSelected, true);

            fill(new ArrayList<>(nums.length));
            return result;
        }

        private void fill(ArrayList<Integer> toFill) {
            for (int i = 0; i < nums.length; i++) {
                if (canBeSelected[i]) {
                    toFill.add(nums[i]);
                    canBeSelected[i] = false;
                    if (toFill.size() == nums.length) {
                        result.add(List.copyOf(toFill));
                    } else {
                        fill(toFill);
                    }
                    toFill.remove(toFill.size() - 1);
                    canBeSelected[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[] {1, 2, 0}));
        System.out.println(new Solution().permute(new int[] {1}));
    }
}
