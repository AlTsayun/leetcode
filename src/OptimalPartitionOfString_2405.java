import java.util.HashSet;

public class OptimalPartitionOfString_2405 {
    private static class Solution {
        public int partitionString(String s) {
            var set = new HashSet<Character>();
            int count = 1;
            for (int i = 0; i < s.length(); i++) {
                if (set.contains(s.charAt(i))) {
                    count++;
                    set.clear();
                }
                set.add(s.charAt(i));
            }
            return count;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().partitionString(""));
        System.out.println(new Solution().partitionString("qwerty"));
        System.out.println(new Solution().partitionString("abcabc"));
        System.out.println(new Solution().partitionString("abcdaabcda"));
        System.out.println(new Solution().partitionString("abacaba"));
        System.out.println(new Solution().partitionString("ssssss"));
        System.out.println(new Solution().partitionString("shkqbyutdvknyrpjof"));
    }
}
