import java.util.Arrays;

public class PlusOne_66 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().plusOne(new int[]{1,2,3})));
        System.out.println(Arrays.toString(new Solution().plusOne(new int[]{4,3,2,1})));
        System.out.println(Arrays.toString(new Solution().plusOne(new int[]{9})));
    }
    private static class Solution {
        public int[] plusOne(int[] digits) {
            int overflow = 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                digits[i] += overflow;
                overflow = digits[i] / 10;
                digits[i] = digits[i] % 10;
            }
            if (overflow == 1) {
                var res = new int[digits.length + 1];
                for (int i = 1; i < res.length - 1; i++) {
                    res[i] = digits[i - 1];
                }
                res[0] = 1;
                return res;
            }
            return digits;
        }
    }
}
