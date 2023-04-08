import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal_145 {
    private static class Solution {
        private static final List<Integer> list = new ArrayList<>();

        public List<Integer> postorderTraversal(TreeNode root) {
            list.clear();
            if (root != null) {
                lre(root);
            }
            return list;
        }

        private void lre(TreeNode node) {
            if (node.left != null) {
                lre(node.left);
            }
            if (node.right != null) {
                lre(node.right);
            }
            list.add(node.val);
        }
    }

    public static void main(String[] args) {
        var root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(new Solution().postorderTraversal(root));
    }
}
