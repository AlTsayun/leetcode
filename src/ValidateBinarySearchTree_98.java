public class ValidateBinarySearchTree_98 {
    private static class Solution {
        public boolean isValidBST(TreeNode root) {
            return isValid(root, null, null);
        }

        private boolean isValid(TreeNode node, Integer low, Integer high) {
            if (node == null) {
                return true;
            }

            boolean isValid = (low == null || node.val > low) && (high == null || node.val < high);

            if (node.left != null) {
                isValid &= isValid(node.left, low, node.val);
            }

            if (node.right != null) {
                isValid &= isValid(node.right, node.val, high);
            }

            return isValid;
        }
    }

    public static void main(String[] args) {
        var root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        System.out.println(new Solution().isValidBST(root));
    }
}
