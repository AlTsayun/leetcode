public class SearchIn2dMatrix_74 {
    static class Solution {

        private int[][] matrix;

        public boolean searchMatrixIterative(int[][] matrix, int target) {
            this.matrix = matrix;
            return iterativeSearch(matrix.length * matrix[0].length, target);
        }

        public boolean searchMatrixRecursive(int[][] matrix, int target) {
            this.matrix = matrix;
            return recursiveSearch(0, matrix.length * matrix[0].length, target);
        }

        private boolean recursiveSearch(int start, int end, int target) {
            if (start == end - 1) {
                return get(start) == target;
            }
            int middle = (start + end) / 2;
            if (target >= get(middle)) {
                return recursiveSearch(middle, end, target);
            } else {
                return recursiveSearch(start, middle, target);
            }
        }

        private boolean iterativeSearch(int length, int target) {
            // inclusive
            int start = 0;
            // exclusive
            int end = length;
            while (start != end - 1) {
                int middle = (start + end) / 2;
                if (target >= get(middle)) {
                    start = middle;
                } else {
                    end = middle;
                }
            }
            return get(start) == target;
        }

        private int get(int i) {
            return matrix[i / matrix[0].length][i % matrix[0].length];
        }
    }
    public static void main(String[] args) {
        System.out.println(new Solution().searchMatrixIterative(new int[][]{{1, 2, 3}, {4, 7, 8}}, 7));
        System.out.println(new Solution().searchMatrixRecursive(new int[][]{{1, 2, 3}, {4, 7, 8}}, 7));
        System.out.println(new Solution().searchMatrixIterative(new int[][]{{-1, 5, 100}}, -1));
        System.out.println(new Solution().searchMatrixRecursive(new int[][]{{-1, 5, 100}}, -1));
        System.out.println(new Solution().searchMatrixIterative(new int[][]{{15}, {19}}, 19));
        System.out.println(new Solution().searchMatrixRecursive(new int[][]{{15}, {19}}, 19));
        System.out.println(new Solution().searchMatrixIterative(new int[][]{{0}}, 0));
        System.out.println(new Solution().searchMatrixRecursive(new int[][]{{0}}, 0));
    }
}