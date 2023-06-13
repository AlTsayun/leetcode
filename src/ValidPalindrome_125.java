public class ValidPalindrome_125 {
    public static void main(String[] args) {
//        System.out.println(new Solution().isPalindrome("A man, a plan, a canal: Panama"));
//        System.out.println(new Solution().isPalindrome("race a car"));
//        System.out.println(new Solution().isPalindrome(" "));
        System.out.println(new Solution().isPalindrome(".,"));
    }

    private static class Solution {

        public boolean isPalindrome(String s) {
            int left = 0;
            int right = s.length() - 1;
            boolean isPalindrome = true;
            while (left < right) {
                while(!isAlphanumeric(s.charAt(left))) {
                    left++;
                    if (left > s.length() - 1) {
                        return true;
                    }
                }
                char nextLeft = Character.toLowerCase(s.charAt(left));
                left++;
                while(!isAlphanumeric(s.charAt(right))) {
                    right--;
                    if (right > s.length() - 1) {
                        return true;
                    }
                }
                char nextRight = Character.toLowerCase(s.charAt(right));
                right--;
                isPalindrome &= nextLeft == nextRight;
            }
            return isPalindrome;
        }

        private boolean isAlphanumeric(char c) {
            return Character.isLetter(c) || Character.isDigit(c);
        }
    }
}
