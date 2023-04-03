import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle_118 {
    static class Solution {
        public List<List<Integer>> generate(int numRows) {
            var triangle = new ArrayList<List<Integer>>(numRows);
            for (int i = 1; i < numRows + 1; i++) {
                insertForLevel(triangle, i);
            }
            return triangle;
        }

        private void insertForLevel(List<List<Integer>> triangle, int level) {
            if (level == 1) {
                triangle.add(List.of(1));
                return;
            }
            var previous = triangle.get(level - 2);
            var insertedSize = previous.size() + 1;
            var inserted = new ArrayList<Integer>(insertedSize);
            for (int i = 0; i < insertedSize; i++) {
                if (i == 0 || i == insertedSize - 1) {
                    inserted.add(1);
                } else {
                   inserted.add(previous.get(i - 1) + previous.get(i));
                }
            }
            triangle.add(inserted);
        }
    }
    public static void main(String[] args) {
        System.out.println(new Solution().generate(4));
        System.out.println(new Solution().generate(1));
        System.out.println(new Solution().generate(15));
    }
}