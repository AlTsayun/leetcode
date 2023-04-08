import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses_20 {
    private static class Solution {
        public boolean isValid(String s) {
            Deque<Character> stack = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (isOpening(c)) {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    var opening = stack.pop();
                    if (!isClosingMatches(opening, c)) {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }

        private boolean isOpening(char bracket) {
            return bracket == '(' || bracket == '{' || bracket == '[';
        }

        private boolean isClosingMatches(char opening, char closing) {
            return opening == '(' && closing == ')'
                    || opening == '{' && closing == '}'
                    || opening == '[' && closing == ']';
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("((()))"));
        System.out.println(new Solution().isValid("((()[])){}"));

        System.out.println(new Solution().isValid("(({){[))"));
        System.out.println(new Solution().isValid("(({})[]))[]"));
    }
}
