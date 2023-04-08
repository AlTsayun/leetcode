public class FirstBadVersion_278 {
    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

    static class VersionControl {
        boolean isBadVersion(int version) {
            return version >= 4;
        }
    }
    private static class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int min = 1;
            int max = n;
            while (min < max) {
                int middle = min + (max - min) / 2;
                if (isBadVersion(middle)) {
                    max = middle;
                } else {
                    min = middle + 1;
                }
            }
            return min;
        }


        public int lastGoodVersion(int n) {
            int min = 0;
            int max = n;
            while (min < max) {
                int middle = min + (max - min) / 2;
                if (isGoodVersion(middle)) {
                    min = middle;
                } else {
                    max = middle - 1;
                }
            }
            return min;
        }

        private boolean isGoodVersion(int n) {
            return ! isBadVersion(n);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().firstBadVersion(12));
        System.out.println(new Solution().lastGoodVersion(12));
    }
}
