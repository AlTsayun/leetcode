public class ZigzagConversion_6 {
    public static void main(String[] args) {
        System.out.println(new Solution().convert("PAYPALISHIRING", 3));
        System.out.println(new Solution().convert("PAYPALISHIRING", 4));
    }

    private static class Solution {

        private char[][] mat;

        public String convert(String s, int numRows) {
            if (numRows == 1) {
                return s;
            }
            var builder = new StringBuilder(s.length());
            int numCols = s.length() / (2 * numRows - 2) * 2 + 2;
            mat = new char[numRows][numCols];
            for (int i = 0; i < s.length(); i++) {
                mat[getWriteRows(i)][getWriteCols(i)] = s.charAt(i);
            }
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    if (mat[i][j] != 0) {
                        builder.append(mat[i][j]);
                    }
                }
            }
            return builder.toString();
        }

        private int getWriteCols(int i) {
            var elementsPerTwoCols = 2 * mat.length - 2;
            var remainder = i % elementsPerTwoCols;
            if (remainder == 0) {
                // top row
                return i / elementsPerTwoCols * 2;
            }
            if (remainder == mat.length - 1) {
                // bottom row
                return i / elementsPerTwoCols * 2;
            }

            if (remainder < mat.length - 1) {
                // the longer row
                return i / elementsPerTwoCols * 2;
            }

            // the shorter row
            return i / elementsPerTwoCols * 2 + 1;
        }

        private int getWriteRows(int i) {
            var elementsPerTwoCols = 2 * mat.length - 2;
            var remainder = i % elementsPerTwoCols;
            if (remainder == 0) {
                // top row
                return 0;
            }
            if (remainder == mat.length - 1) {
                // bottom row
                return mat.length - 1;
            }

            if (remainder < mat.length) {
                // the longer row
                return remainder;
            }

            // the short row
            return mat.length - (remainder - mat.length) - 2;
        }
    }
}
