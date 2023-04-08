public class NumberOfClosedIslands_1254 {
    private static class Solution {
        private static final int LAND = 0;
        private static final int SEEN_LAND = 2;

        private int [][] map;
        public int closedIsland(int[][] grid) {
            map = grid;
            var columns = grid[0].length;
            var rows = grid.length;
            int closedIslands = 0;

            for (int i = 0; i < rows * columns; i++) {
                if (grid[i / columns][i % columns] == LAND) {
                    boolean isClosedIsland = discover(i / columns, i % columns);
                    if (isClosedIsland) {
                        closedIslands++;
                    }
                }
            }
            return closedIslands;
        }

        private boolean discover(int row, int column) {
            if (map[row][column] == LAND) {
                map[row][column] = SEEN_LAND;
                boolean isOuterClosed = true;
                if (row > 0) {
                    boolean isTopClosed = discover(row - 1, column);
                    isOuterClosed &= isTopClosed;
                }
                if (column < map[0].length - 1) {
                    boolean isRightClosed = discover(row, column + 1);
                    isOuterClosed &= isRightClosed;
                }
                if (row < map.length - 1) {
                    boolean isBottomClosed = discover(row + 1, column);
                    isOuterClosed &= isBottomClosed;
                }

                if (column > 0) {
                    boolean isLeftClosed = discover(row, column - 1);
                    isOuterClosed &= isLeftClosed;
                }
                return isOuterClosed && !isMapEdge(row, column);
            }
            return true;
        }

        private boolean isMapEdge(int row, int column) {
           return row == 0 || row == map.length - 1 || column == 0 || column == map[0].length - 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().closedIsland(new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}
        }));
    }
}
