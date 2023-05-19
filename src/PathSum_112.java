public class PathSum_112 {
    private static class Solution {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }
            var newTargetSum = targetSum - root.val;
            if (newTargetSum == 0 && root.left == null && root.right == null) {
                return true;
            }
            boolean hasPath = false;
            if (root.left != null) {
                hasPath |= hasPathSum(root.left, newTargetSum);
            }
            if (root.right != null) {
                hasPath |= hasPathSum(root.right, newTargetSum);
            }
            return hasPath;
        }
    }

    public static void main(String[] args) {
        var root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        System.out.println(new Solution().hasPathSum(root, 22));
    }
}
