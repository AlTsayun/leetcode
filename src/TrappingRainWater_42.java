import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingRainWater_42 {
    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{4, 2, 0, 3, 2, 5}));
    }

    private static class Solution {
        public int trap(int[] height) {
            int flooded = 0;
            Deque<Integer> peaks = new ArrayDeque<>();
            for (int i = 1; i < height.length; i++) {
                if (height[i - 1] > height[i]) {
                    peaks.push(i - 1);
                }
                if (height[i - 1] < height[i]) {
                    int toLevel = height[i];
                    int fromLevel = height[i - 1];
                    var previousPeak = peaks.peek();
                    while (previousPeak != null) {
                        int width = i - previousPeak - 1;
                        if (height[previousPeak] < toLevel) {
                            int depth = height[previousPeak] - fromLevel;
                            fromLevel += depth;
                            flooded += width * depth;
                            peaks.pop();
                            previousPeak = peaks.peek();
                        } else {
                            int depth = toLevel - fromLevel;
                            flooded += width * depth;
                            break;
                        }
                    }
                }
            }
            return flooded;
        }
    }
}
