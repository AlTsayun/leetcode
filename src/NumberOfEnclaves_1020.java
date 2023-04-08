public class NumberOfEnclaves_1020 {
    private static class Solution {
        private static final int LAND = 1;
        private static final int SEEN_LAND = 2;

        private int [][] map;

        private boolean isEnclave;
        public int numEnclaves(int[][] grid) {
            map = grid;
            var columns = grid[0].length;
            var rows = grid.length;
            int enclaves = 0;

            for (int i = 0; i < rows * columns; i++) {
                if (grid[i / columns][i % columns] == LAND) {
                    isEnclave = true;
                     int discoveredLand = discover(i / columns, i % columns);
                     if (isEnclave) {
                         enclaves += discoveredLand;
                     }
                }
            }
            return enclaves;
        }

        private int discover(int row, int column) {
            if (map[row][column] == LAND) {
                if (isMapEdge(row, column)) {
                    isEnclave = false;
                }
                map[row][column] = SEEN_LAND;
                int discovered = 1;

                if (row > 0) {
                    discovered += discover(row - 1, column);
                }
                if (column < map[0].length - 1) {
                    discovered += discover(row, column + 1);
                }
                if (row < map.length - 1) {
                    discovered += discover(row + 1, column);
                }
                if (column > 0) {
                    discovered += discover(row, column - 1);
                }
                return discovered;
            }
            return 0;
        }

        private boolean isMapEdge(int row, int column) {
           return row == 0 || row == map.length - 1 || column == 0 || column == map[0].length - 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numEnclaves(new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}
        }));
        System.out.println(new Solution().numEnclaves(new int[][]{
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0},
        }));
        System.out.println(new Solution().numEnclaves(new int[][]{
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
        }));
    }
}
