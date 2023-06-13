import java.util.Arrays;

public class SetMatrixZeroes_73 {
    public static void main(String[] args) {
        var matrix = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
//        new Solution().setZeroes(matrix);
//        System.out.println(Arrays.deepToString(matrix));
        matrix = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        new Solution().setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    private static class Solution {
        public void setZeroes(int[][] matrix) {
            boolean isFirstRow = false;
            boolean isFirstCol = false;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][0] == 0) {
                    isFirstRow = true;
                    break;
                }
            }
            for (int i = 0; i < matrix[0].length; i++) {
                if (matrix[0][i] == 0) {
                    isFirstCol = true;
                    break;
                }
            }
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                }
            }

            for (int i = 1; i < matrix.length; i++) {
                if (matrix[i][0] == 0) {
                    for (int j = 1; j < matrix[i].length; j++) {
                        matrix[i][j] = 0;
                    }
                }
            }

            for (int i = 1; i < matrix[0].length; i++) {
                if (matrix[0][i] == 0) {
                    for (int j = 1; j < matrix.length; j++) {
                        matrix[j][i] = 0;
                    }
                }
            }

            if (isFirstCol) {
                Arrays.fill(matrix[0], 0);
            }
            if (isFirstRow) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][0] = 0;
                }
            }
        }
    }
}
