import java.util.ArrayDeque;
import java.util.Arrays;

public class ZeroOneMatrix_542 {

    public static void main(String[] args) {
        int[][] mat = new int[][]{{0,0,0},{0,1,0},{1,1,1}};
        System.out.println(Arrays.deepToString(new Solution().updateMatrix(mat)));
    }

    private static class Solution {
        private static final int UNPROCESSED = -1;
        private int[][] mat;
        private final ArrayDeque<int[]> queue = new ArrayDeque<>();

        public int[][] updateMatrix(int[][] mat) {
            this.mat = mat;
            collectZerosToQueue(mat);

            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                int row = curr[0];
                int column = curr[1];

                addNeghbourToQueueIfNeeded(row, column, 0, 1);
                addNeghbourToQueueIfNeeded(row, column, 1, 0);
                addNeghbourToQueueIfNeeded(row, column, 0, -1);
                addNeghbourToQueueIfNeeded(row, column, -1, 0);
            }
            return mat;
        }

        private void collectZerosToQueue(int[][] mat) {
            for (int r = 0; r < mat.length; r++) {
                for (int c = 0; c < mat[0].length; c++) {
                    if (mat[r][c] == 0) {
                        queue.offer(new int[]{r, c});
                    } else {
                        mat[r][c] = UNPROCESSED;
                    }
                }
            }
        }

        private void addNeghbourToQueueIfNeeded(int row, int column, int rowStep, int columnStep) {
            var newRow = row +rowStep;
            var newColumn = column + columnStep;
            if (isValidColumn(newColumn) && isValidRow(newRow) && mat[newRow][newColumn] == UNPROCESSED) {
                mat[newRow][newColumn] = mat[row][column] + 1;
                queue.offer(new int[]{newRow, newColumn});
            }
        }

        private boolean isValidRow(int row) {
            return row >= 0 && row < mat.length;
        }

        private boolean isValidColumn(int column) {
            return column >= 0 && column < mat[0].length;
        }
    }
}
