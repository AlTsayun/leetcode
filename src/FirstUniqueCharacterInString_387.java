public class FirstUniqueCharacterInString_387 {
    private static class Solution {
        public int firstUniqChar(String s) {
            var map = new int[26];
            for (int i = 0; i < s.length(); i++) {
                var c = s.charAt(i) - 'a';
                map[c]++;
            }

            for (int i = 0; i < s.length(); i++) {
                var c = s.charAt(i) - 'a';
                if (map[c] == 1) {
                    return i;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        var t = "cat";
        System.out.println(new Solution().firstUniqChar(t));
        t = "cac";
        System.out.println(new Solution().firstUniqChar(t));
    }
}
