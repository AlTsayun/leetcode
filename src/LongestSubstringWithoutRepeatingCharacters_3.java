import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters_3 {
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int length = 0;
            int maxLength = 0;
            var set = new HashSet<Character>();
            int i = 0;
            while (i < s.length()) {
                while (set.contains(s.charAt(i))) {
                    set.remove(s.charAt(i - length));
                    length--;
                }
                set.add(s.charAt(i));
                length++;
                i++;
                maxLength = Math.max(maxLength, length);
            }
            return maxLength;
        }
    }
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("aab"));
        System.out.println(new Solution().lengthOfLongestSubstring("dvdf"));
        System.out.println(new Solution().lengthOfLongestSubstring(""));
    }
}
