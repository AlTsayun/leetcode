public class LongestCommonPrefix_14 {
    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonPrefix(new String[] {"flower","flow","flight"}));
        System.out.println(new Solution().longestCommonPrefix(new String[] {"dog","racecar","car"}));
        System.out.println(new Solution().longestCommonPrefix(new String[] {"123","123","123"}));
        System.out.println(new Solution().longestCommonPrefix(new String[] {"12","123","123"}));
    }

    private static class Solution {
        public String longestCommonPrefix(String[] strs) {
            return longestCommonPrefix(strs, 0, strs.length);
        }

        private String longestCommonPrefix(String[] strs, int from, int to) {
            if (from == to - 1) {
                return strs[from];
            }

            int mid = (to - from) / 2 + from;
            var leftPrefix = longestCommonPrefix(strs, from, mid);
            var rightPrefix = longestCommonPrefix(strs, mid, to);

            return getLongestCommon(leftPrefix, rightPrefix);
        }

        private String getLongestCommon(String one, String another) {
            int to = 0;
            for (int i = 0; i < one.length(); i++) {
                if (i > another.length() - 1) {
                    break;
                }
                if (one.charAt(i) == another.charAt(i)) {
                    to++;
                } else {
                    break;
                }
            }
            return one.substring(0, to);
        }
    }
}
