import java.util.Arrays;
import java.util.HashMap;

public class TwoSumTwo_167 {
    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            var map = new HashMap<Integer, Integer>(numbers.length);
            for (int i = 0; i < numbers.length; i++) {
                var found = map.get(numbers[i]);
                if (found != null) {
                    return new int[] {found + 1, i + 1};
                }
                map.put(target - numbers[i], i);
            }
            throw new RuntimeException();
        }

        public int[] twoSum2(int[] numbers, int target) {
            int left = 0;
            int right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[left] + numbers[right];
                if (sum == target) {
                    return new int[] {left + 1, right + 1};
                }
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
            throw new RuntimeException();
        }
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[] {-3,-2,1,1,2,3,4,6}, 6)));
        System.out.println(Arrays.toString(new Solution().twoSum(new int[] {-1, 0, 3, 4}, -1)));
        System.out.println(Arrays.toString(new Solution().twoSum(new int[] {-4, -3, -1, 1, 2}, -4)));
        System.out.println(Arrays.toString(new Solution().twoSum2(new int[] {-3,-2,1,1,2,3,4,6}, 6)));
        System.out.println(Arrays.toString(new Solution().twoSum2(new int[] {-1, 0, 3, 4}, -1)));
        System.out.println(Arrays.toString(new Solution().twoSum2(new int[] {-4, -3, -1, 1, 2}, -4)));
    }
}
