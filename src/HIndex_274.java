
public class HIndex_274 {
    public static void main(String[] args) {
        System.out.println(new Solution().hIndex(new int[]{3, 0, 6, 1, 5}));
        System.out.println(new Solution().hIndex(new int[]{1, 3, 1}));
    }

    private static class Solution {
        private final int[] indexCount = new int[1001];
        private int maxHIndex;

        public int hIndex(int[] citations) {
            for (int currentCitation : citations) {
                for (int j = maxHIndex; j < currentCitation + 1; j++) {
                    indexCount[j]++;
                    if (indexCount[j] == j) {
                        maxHIndex = Math.max(maxHIndex, j);
                    }
                }
            }
            return maxHIndex;
        }
    }
}
