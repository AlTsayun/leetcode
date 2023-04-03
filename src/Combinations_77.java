import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations_77 {
    static class Solution {

        private ArrayList<List<Integer>> result;
        private int maxSize;

        public List<List<Integer>> combine(int n, int k) {
            result = new ArrayList<>();
            maxSize = k;
            fill(1, n, new ArrayList<>(k));
            return result;
        }

        private void fill(int from, int to, ArrayList<Integer> toFill) {
            for (int i = from; i <= to; i++) {
                toFill.add(i);
                if (toFill.size() == maxSize) {
                    result.add(List.copyOf(toFill));
                } else {
                    fill(i + 1, to, toFill);
                }
                toFill.remove(toFill.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combine(4, 2));
        System.out.println(new Solution().combine(1, 1));
        System.out.println(new Solution().combine(5, 3));
    }
}
