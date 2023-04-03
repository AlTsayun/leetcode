import java.util.Arrays;
import java.util.Comparator;

public class SuccessfulPairsOfSpellsAndPotions_2300 {
    static class Solution {
        private int spell;
        private long success;

        public int[] successfulPairs(int[] spells, int[] potions, long success) {
            this.success = success;
            Arrays.sort(potions);
            for (int i = 0; i < spells.length; i++) {
               spell = spells[i];
               spells[i] = potions.length - searchFirstPotionBinary(potions);
            }
            return spells;
        }

        public int[] successfulPairsTwoPointers(int[] spells, int[] potions, long success) {
            int[][] spellsWithIndexes = new int[spells.length][2];
            int[] pairs = new int[spells.length];
            for (int i = 0; i < spells.length; i++) {
                spellsWithIndexes[i][0] = spells[i];
                spellsWithIndexes[i][1] = i;
            }

            Arrays.sort(spellsWithIndexes, (a, b) -> Integer.compare(b[0], a[0]));
            Arrays.sort(potions);
            int i = 0;
            for (int[] spellWithIndex : spellsWithIndexes) {
                while (i < potions.length && (long) potions[i] * spellWithIndex[0] < success) {
                    i++;
                }
                int count = potions.length - i;
                pairs[spellWithIndex[1]] = count;
            }
            return pairs;
        }

        private int searchFirstPotionBinary(int[] potions) {
            int left = 0;
            int right = potions.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (isGoodPotion(potions[mid])) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return right;
        }

        private boolean isGoodPotion(int potion) {
            return (long) spell * potion >= success;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().successfulPairs(new int[] {5, 1, 3}, new int[] {1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(new Solution().successfulPairs(new int[] {3, 1, 2}, new int[] {8, 5, 8}, 16)));
        System.out.println(Arrays.toString(new Solution().successfulPairsTwoPointers(new int[] {5, 1, 3}, new int[] {1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(new Solution().successfulPairsTwoPointers(new int[] {3, 1, 2}, new int[] {8, 5, 8}, 16)));
    }
}
