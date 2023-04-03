import java.util.Arrays;

public class PermutationInString_567 {
    static class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length() > s2.length()) {
                return false;
            }
            var occurrences = new int[26];
            var window = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                occurrences[s1.charAt(i) - 'a']++;
                window[s2.charAt(i) - 'a']++;
            }
            for (int i = 0; i < s2.length() - s1.length(); i++) {
                if (Arrays.equals(occurrences, window)) {
                    return true;
                }
                window[s2.charAt(i) - 'a']--;
                window[s2.charAt(i + s1.length()) - 'a']++;
            }
            return Arrays.equals(occurrences, window);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkInclusion("ek", "pwwkew"));
        System.out.println(new Solution().checkInclusion("adc", "dcda"));
    }
}
