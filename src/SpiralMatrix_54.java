import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {
    public static void main(String[] args) {
        System.out.println(new Solution().spiralOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }));
        System.out.println(new Solution().spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        }));
    }

    private static class Solution {
        private static final int[][] dirs = new int[][] { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
        // TODO try with constant extra space without isVisited using anker-points to determine where to turn direction
        private static int[] topLeft;
        private static int[] topRight;
        private static int[] bottomRight;
        private static int[] bottomLeft;
        private int cur = 0;
        private boolean[][] isVisited;

        public List<Integer> spiralOrder(int[][] matrix) {
            var res = new ArrayList<Integer>();
            int posi = 0;
            int posj = 0;
            isVisited = new boolean[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length * matrix[0].length; i++) {
                res.add(matrix[posi][posj]);
                isVisited[posi][posj] = true;
                if (!canMoveFurther(posi, posj)) {
                    turn();
                }
                posi += dirs[cur][0];
                posj += dirs[cur][1];
            }
            return res;
        }

        private boolean canMoveFurther(int posi, int posj) {
            posi += dirs[cur][0];
            posj += dirs[cur][1];
            if (posi > isVisited.length - 1 || posi < 0) {
                return false;
            }
            if (posj > isVisited[0].length - 1 || posj < 0) {
                return false;
            }
            return !isVisited[posi][posj];
        }

        private void turn() {
            if (cur != 3) {
                cur++;
            } else {
                cur = 0;
            }
        }
    }
}
