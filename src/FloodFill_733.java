import java.util.Arrays;

public class FloodFill_733 {
    private static class Solution {
        private int source;
        private int[][] image;
        private int color;

        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            this.image = image;
            this.color = color;
            this.source = image[sr][sc];
            if (source != color) {
                fill(sr, sc);
            }
            return image;
        }

        private void fill(int row, int column) {
            if (image[row][column] == source) {
                image[row][column] = color;
                if (row > 0) {
                    fill(row - 1, column);
                }
                if (column > 0) {
                    fill(row, column - 1);
                }
                if (row < image.length - 1) {
                    fill(row + 1, column);
                }
                if (column < image[0].length - 1) {
                    fill(row, column + 1);
                }
            }
        }
    }
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2)));
        System.out.println(Arrays.deepToString(new Solution().floodFill(new int[][]{{0, 0, 0}, {0, 0, 0}}, 0, 0, 0)));
        System.out.println(Arrays.deepToString(new Solution().floodFill(new int[][]{{1, 1}, {0, 0}}, 1, 0, 2)));
    }
}