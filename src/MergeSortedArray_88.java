public class MergeSortedArray_88 {
    static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i = m-1;
            int j = n-1;
            int k = m + n - 1;
            while (k > -1) {
                if (i == -1) {
                    nums1[k] = nums2[j];
                    j--;
                    k--;
                    continue;
                }
                if (j == -1) {
                    nums1[k] = nums1[i];
                    i--;
                    k--;
                    continue;
                }
                if (nums1[i] > nums2[j]) {
                    nums1[k] = nums1[i];
                    i--;
                } else {
                    nums1[k] = nums2[j];
                    j--;
                }
                k--;
            }
        }
    }
    public static void main(String[] args) {

    }
}
