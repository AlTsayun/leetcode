public class MergeTwoBinaryTrees_617 {
    static class Solution {

        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            var node = new TreeNode(getVal(root1) + getVal(root2));
            if (root1 == null) {
                return root2;
            }
            if (root2 == null) {
                return root1;
            }
            if (!(root1.left == null && root2.left == null)) {
                node.left = mergeTrees(root1.left, root2.left);
            }
            if (!(root1.right == null && root2.right == null)) {
                node.right = mergeTrees(root1.right, root2.right);
            }
            return node;
        }

        private int getVal(TreeNode node) {
            if (node == null) {
                return 0;
            } else {
                return node.val;
            }
        }
    }
    public static void main(String[] args) {
        var root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.left.left = new TreeNode(5);
        root1.right = new TreeNode(2);

        var root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.left.right = new TreeNode(4);
        root2.right = new TreeNode(3);
        root2.right.right = new TreeNode(7);

        var root = new Solution().mergeTrees(root1, root2);
        System.out.println(root);
    }
}