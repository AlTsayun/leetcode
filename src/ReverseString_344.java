import java.util.Arrays;

public class ReverseString_344 {
    static class Solution {
        public void reverseString(char[] s) {
            char tmp;
            for (int i = 0; i < s.length / 2; i++) {
                var j = s.length - 1 - i;
                if (s[i] != s[j]) {
                    tmp = s[i];
                    s[i] = s[j];
                    s[j] = tmp;
                }
            }
        }
    }
    public static void main(String[] args) {
        var str = new char[]{'H', 'e', 'l', 'l', 'o'};
        new Solution().reverseString(str);
        System.out.println(Arrays.toString(str));
    }
}
