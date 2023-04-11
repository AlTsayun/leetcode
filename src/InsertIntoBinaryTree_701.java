public class InsertIntoBinaryTree_701 {
    private static class Solution {
        public TreeNode insertIntoBSTWithPrev(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            TreeNode prev = null;
            var node = root;
            while (node != null) {
                prev = node;
                if (val < node.val) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }

            if (val < prev.val) {
                prev.left = new TreeNode(val);
            } else {
                prev.right = new TreeNode(val);
            }

            return root;
        }
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            var node = root;
            while (true) {
                if (val < node.val) {
                    if (node.left == null) {
                        node.left = new TreeNode(val);
                        break;
                    }
                    node = node.left;
                } else {
                    if (node.right == null) {
                        node.right = new TreeNode(val);
                        break;
                    }
                    node = node.right;
                }
            }
            return root;
        }
    }

    public static void main(String[] args) {
        var root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);

        var newRoot = new Solution().insertIntoBST(root, 5);
        newRoot = new Solution().insertIntoBSTWithPrev(root, 6);
        System.out.println(newRoot);
    }
}
