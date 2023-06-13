import java.util.HashMap;

public class WordPattern_290 {
    public static void main(String[] args) {
        System.out.println(new Solution().wordPattern("abba", "dog cat cat dog"));
        System.out.println(new Solution().wordPattern("abba", "dog cat cat fish"));
        System.out.println(new Solution().wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(new Solution().wordPattern("abcs", "dog cat cat dog"));
    }

    private static class Solution {
        public boolean wordPattern(String pattern, String s) {
            var encountered = new HashMap<Character, String>();
            var words = s.split(" ");
            if (pattern.length() != words.length) {
                return false;
            }
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                var key = pattern.charAt(i);
                var associatedWord = encountered.get(key);
                if (associatedWord == null) {
                    if (encountered.containsValue(word)) {
                        // word is mapped to a different kay
                        return false;
                    }
                    encountered.put(key, word);
                } else {
                    if (!word.equals(associatedWord)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
