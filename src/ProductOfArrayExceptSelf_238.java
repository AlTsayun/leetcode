import java.util.Arrays;

public class ProductOfArrayExceptSelf_238 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    private static class Solution {
        public int[] productExceptSelf(int[] nums) {
            var res = new int[nums.length];
            var runningProduct = 1;
            for (int i = 0; i < nums.length; i++) {
                res[i] = runningProduct;
                runningProduct *= nums[i];
            }
            runningProduct = 1;
            for (int i = nums.length - 1; i > -1; i--) {
                res[i] = res[i] * runningProduct;
                runningProduct *= nums[i];
            }
            return res;
        }
    }
}
