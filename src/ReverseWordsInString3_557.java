public class ReverseWordsInString3_557 {
    static class Solution {
        public String reverseWords(String s) {
            var builder = new StringBuilder(s.length() + 1);
            var wordStart = 0;
            var wordEnd = 0;
            for (int i = 0; i < s.length() + 1; i++) {
                if (i == s.length() || s.charAt(i) == ' ') {
                    wordEnd = i;
                    reverseAppend(builder, s, wordStart, wordEnd);
                    builder.append(' ');
                    wordStart = i + 1;
                }
            }
            return builder.substring(0, s.length());
        }

        private void reverseAppend(StringBuilder builder, String string, int from, int to) {
            for (int i = to - 1; i >= from; i--) {
                builder.append(string.charAt(i));
            }
        }
    }
    public static void main(String[] args) {
        var str = "Let's take LeetCode contest";
        System.out.println(new Solution().reverseWords(str));
    }
}
