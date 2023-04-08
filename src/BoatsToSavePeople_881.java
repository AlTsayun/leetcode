import java.util.Arrays;

public class BoatsToSavePeople_881 {
    private static class Solution {
        public int numRescueBoats(int[] people, int limit) {
            Arrays.sort(people);
            int acc = 0;
            int left = 0;
            int right = people.length - 1;
            while (left <= right) {
                if (people[left] + people[right] <= limit) {
                    left++;
                }
                right--;
                acc++;
            }
            return acc;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numRescueBoats(new int[]{3, 2, 2, 1}, 3));
        System.out.println(new Solution().numRescueBoats(new int[]{3, 5, 3, 4}, 5));
    }
}
