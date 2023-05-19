public class SearchInABinarySearchTree_700 {
    private static class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null) {
                return null;
            }
            if (val == root.val) {
                return root;
            }
            if (val < root.val) {
                return searchBST(root.left, val);
            } else  {
                return searchBST(root.right, val);
            }
        }
    }

    public static void main(String[] args) {
        var root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        System.out.println(new Solution().searchBST(root, 2));
        System.out.println(new Solution().searchBST(root, 5));
    }
}
