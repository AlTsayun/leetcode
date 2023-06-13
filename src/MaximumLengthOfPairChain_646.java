import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.function.Function;

public class MaximumLengthOfPairChain_646 {
    public static void main(String[] args) {
        System.out.println(new Solution().findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
    }

    private static class Solution {
        public int findLongestChain(int[][] pairs) {
            Arrays.sort(pairs, Comparator.comparing(pair -> pair[1]));
            int cur = Integer.MIN_VALUE;
            int ans = 0;
            for (int[] pair : pairs) {
                if (cur < pair[0]) {
                    cur = pair[1];
                    ans++;
                }
            }
            return ans;
        }
    }
}
