public class SymmetricTree_101 {
    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            return isSymmetric(root.left, root.right);
        }

        private boolean isSymmetric(TreeNode left, TreeNode right) {
            return (left == null) && (right == null)
                    || (left != null) && (right != null)
                    && left.val == right.val
                    && isSymmetric(left.left, right.right)
                    && isSymmetric(left.right, right.left);
        }
    }

    public static void main(String[] args) {

    }
}
