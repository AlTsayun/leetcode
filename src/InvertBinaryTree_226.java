public class InvertBinaryTree_226 {
    private static class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            var tmp = root.right;
            root.right = invertTree(root.left);
            root.left = invertTree(tmp);
            return root;
        }
    }

    public static void main(String[] args) {
        var root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        new Solution().invertTree(root);
    }
}
