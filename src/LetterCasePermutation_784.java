import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation_784 {
    private static class Solution {

        private String s;
        private List<String> result;

        public List<String> letterCasePermutation(String s) {
            this.s = s;
            result = new ArrayList<>();
            lookForPermutations(0, new ArrayList<>(s.length()));
            return result;
        }

        private void lookForPermutations(int from, List<Character> toFill) {
            for (int i = from; i < s.length(); i++) {
                var c = s.charAt(i);
                if (Character.isLetter(c)) {
                    claimCharAt(c, i, toFill);
                    c = swapCase(c);
                    claimCharAt(c, i, toFill);
                } else {
                    claimCharAt(c, i, toFill);
                }
            }
        }

        private void claimCharAt(char c, int i, List<Character> toFill) {
            toFill.add(c);
            if (toFill.size() == s.length()) {
                result.add(toString(toFill));
            } else {
                lookForPermutations(i + 1, toFill);
            }
            toFill.remove(toFill.size() - 1);
        }

        private String toString(List<Character> chars) {
            var builder = new StringBuilder();
            for (char c : chars) {
                builder.append(c);
            }
            return builder.toString();
        }

        private char swapCase(char c) {
            if (Character.isUpperCase(c)) {
                return Character.toLowerCase(c);
            }
            if (Character.isLowerCase(c)) {
                return Character.toUpperCase(c);
            }
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCasePermutation("a1b2"));
        System.out.println(new Solution().letterCasePermutation("3z4"));
        System.out.println(new Solution().letterCasePermutation("A"));
        System.out.println(new Solution().letterCasePermutation("Aa"));
        System.out.println(new Solution().letterCasePermutation(""));
        System.out.println(new Solution().letterCasePermutation("1"));
    }
}
