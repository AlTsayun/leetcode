public class BalancedBinaryTree_110 {
    static class Solution {
        public boolean isBalancedExceptionally(TreeNode root) {
            try {
                if (root == null) {
                    return true;
                }
                getDepthExceptionally(root);
                return true;
            } catch(RuntimeException e) {
                return false;
            }
        }

        private int getDepthExceptionally(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int leftDepth = 0;
            int rightDepth = 0;

            if (node.left != null) {
                leftDepth = getDepthExceptionally(node.left);
            }

            if (node.right != null) {
                rightDepth = getDepthExceptionally(node.right);
            }
            if (!isBalanced(leftDepth, rightDepth)) {
                throw new RuntimeException();
            }
            return Math.max(leftDepth, rightDepth) + 1;
        }

        private boolean isBalanced(int leftDepth, int rightDepth) {
            return Math.abs(leftDepth - rightDepth) < 2;
        }

        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            var rightDepth = getDepth(root.right);
            var leftDepth = getDepth(root.left);
            return isBalanced(leftDepth, rightDepth) && isBalanced(root.left) && isBalanced(root.right);
        }

        private int getDepth(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int leftDepth = 0;
            int rightDepth = 0;

            if (node.left != null) {
                leftDepth = getDepth(node.left);
            }

            if (node.right != null) {
                rightDepth = getDepth(node.right);
            }
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

    public static void main(String[] args) {
        var root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Solution().isBalancedExceptionally(root));
        System.out.println(new Solution().isBalanced(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);
        System.out.println(new Solution().isBalancedExceptionally(root));
        System.out.println(new Solution().isBalanced(root));
    }
}
