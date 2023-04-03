import java.util.HashMap;
import java.util.Map;

public class ValidAnagram_242 {
    static class Solution {
        private final Map<Character, Integer> map = new HashMap<>();
        public boolean isAnagramWithMap(String s, String t) {
            fillMap(s);
            for (int i = 0; i < t.length(); i++) {
                var c = t.charAt(i);
                if (map.containsKey(c)) {
                    map.computeIfPresent(c, (k, count) -> {
                        if (count != 1) {
                            return count - 1;
                        } else {
                            return null;
                        }
                    });
                } else {
                    return false;
                }
            }
            return map.isEmpty();
        }

        private void fillMap(String s) {
            map.clear();
            s.chars().forEachOrdered(c -> map.compute((char) c, (k, v) -> {
                if (v == null) {
                    return 1;
                } else {
                    return v + 1;
                }
            }));
        }

        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            int[] map = new int[26];
            for (int i = 0; i < s.length(); i++) {
                map[s.charAt(i) - 'a']++;
                map[t.charAt(i) - 'a']--;
            }
            for (int i = 0; i < 26; i++) {
                if (map[i] != 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        var s = "cat";
        var t = "cat";
        System.out.println(new Solution().isAnagram(s, t));
        System.out.println(new Solution().isAnagramWithMap(s, t));
        s = "cat";
        t = "cac";
        System.out.println(new Solution().isAnagram(s, t));
        System.out.println(new Solution().isAnagramWithMap(s, t));
    }
}
