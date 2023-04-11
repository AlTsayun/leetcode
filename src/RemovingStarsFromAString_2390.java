public class RemovingStarsFromAString_2390 {
    private static class Solution {
        public String removeStars(String s) {
            var builder = new StringBuilder();
            int i = 0;
            while (i < s.length()) {
                char c = s.charAt(i);
                if (c == '*') {
                    builder.deleteCharAt(builder.length() - 1);
                } else {
                    builder.append(c);
                }
                i++;
            }
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeStars("leet**cod*e"));
        System.out.println(new Solution().removeStars("erase*****"));
    }
}
