public class ReverseWordsInAString_151 {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("the sky is blue"));
    }

    private static class Solution {
        public String reverseWords(String s) {
            int wordStart = 0;
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < s.length() + 1; i++) {
                if (isBeginningOfWord(s, i)) {
                    wordStart = i;
                }
                if (isEndOfWord(s, i)) {
                    builder.insert(0, s.substring(wordStart, i)).insert(0, ' ');
                }
            }
            return builder.substring(1);
        }

        private boolean isEndOfWord(String s, int i) {
            if (i < 1) {
                return false;
            }
            boolean res = s.charAt(i - 1) != ' ';
            if (i < s.length()) {
                res &= s.charAt(i) == ' ';
            }
            return res;
        }

        private boolean isBeginningOfWord(String s, int i) {
            if (i > s.length() - 1) {
                return false;
            }
            boolean res = s.charAt(i) != ' ';
            if (i > 0) {
                res &= s.charAt(i - 1) == ' ';
            }
            return res;
        }
    }
}
