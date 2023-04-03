public class MaxAreaOfIsland_695 {
    static class Solution {
        private static final int LAND = 1;
        private static final int SEEN_LAND = 2;
        private int[][] map;

        private int currentIslandArea = 0;
        private int maxIslandArea = 0;

        public int maxAreaOfIsland(int[][] grid) {
            map = grid;
            var columns = grid[0].length;
            var rows = grid.length;
            for (int i = 0; i < rows * columns; i++) {
                if (grid[i / columns][i % columns] == LAND) {
                    discover(i / columns, i % columns);
                    currentIslandArea = 0;
                }
            }
            return maxIslandArea;
        }

        private void discover(int row, int column) {
            if (map[row][column] == LAND) {
                map[row][column] = SEEN_LAND;
                currentIslandArea++;
                maxIslandArea = Math.max(currentIslandArea, maxIslandArea);
                if (row > 0) {
                    discover(row - 1, column);
                }
                if (column > 0) {
                    discover(row, column - 1);
                }
                if (row < map.length - 1) {
                    discover(row + 1, column);
                }
                if (column < map[0].length - 1) {
                    discover(row, column + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxAreaOfIsland(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}));
        System.out.println(new Solution().maxAreaOfIsland(new int[][]{{0, 0, 0}, {0, 0, 0}}));
        System.out.println(new Solution().maxAreaOfIsland(new int[][]{{1, 1}, {0, 0}}));
        System.out.println(new Solution().maxAreaOfIsland(new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        }));
    }
}