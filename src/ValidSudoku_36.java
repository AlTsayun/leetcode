import java.util.HashSet;
import java.util.Set;

public class ValidSudoku_36 {
    private static class Solution {
        Set<Character> set = new HashSet<>(9);
        public boolean isValidSudoku(char[][] board) {
            boolean isValid = true;
            for (int i = 0; i < 9; i++) {
                isValid &= isHorizontalLineValid(board, i);
            }
            for (int i = 0; i < 9; i++) {
                isValid &= isVerticalLineValid(board, i);
            }
            for (int i = 0; i < 9; i++) {
                isValid &= isCubeValid(board, i);
            }
            return isValid;
        }

        private boolean isHorizontalLineValid(char[][] board, int lineIndex) {
            boolean isValid = true;
            for (char c : board[lineIndex]) {
                isValid &= c == '.' || set.add(c);
            }
            set.clear();
            return isValid;
        }

        private boolean isVerticalLineValid(char[][] board, int lineIndex) {
            boolean isValid = true;
            for (int i = 0; i < 9; i++) {
                char c = board[i][lineIndex];
                isValid &= c == '.' || set.add(c);
            }
            set.clear();
            return isValid;
        }

        private boolean isCubeValid(char[][] board, int cubeIndex) {
            int startI = cubeIndex % 3 * 3;
            int startJ = cubeIndex / 3 * 3;
            boolean isValid = true;
            for (int i = 0; i < 9; i++) {
                char c = board[startI + i / 3][startJ + i % 3];
                isValid &= c == '.' || set.add(c);
            }
            set.clear();
            return isValid;
        }
    }
    public static void main(String[] args) {
        System.out.println(new Solution().isValidSudoku(createTrulyBoard()));
        System.out.println(new Solution().isValidSudoku(createFalsyBoard()));
    }

    private static char[][] createTrulyBoard() {
        return new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
    }

    private static char[][] createFalsyBoard() {
        return new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
    }
}