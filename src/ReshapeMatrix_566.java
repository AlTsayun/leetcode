import java.util.Arrays;

public class ReshapeMatrix_566 {
    static class Solution {
        public int[][] matrixReshape(int[][] mat, int r, int c) {
            int m = mat.length;
            int n = mat[0].length;
            if (r * c != m * n) {
                return mat;
            }
            final int[][] res = new int[r][c];
            for (int i = 0; i < m * n; i++) {
                res[i / c][i % c] = mat[i / n][i % n];
            }
            return res;
        }
    }
    public static void main(String[] args) {
        var start = System.currentTimeMillis();
        System.out.println(Arrays.deepToString(new Solution().matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4)));
        System.out.println(Arrays.deepToString(new Solution().matrixReshape(new int[][]{{1, 2}, {3, 4}}, 4, 1)));
        System.out.println(Arrays.deepToString(new Solution().matrixReshape(new int[][]{{1, 2}, {3, 4}}, 2, 4)));
        System.out.println(System.currentTimeMillis() - start);
    }
}