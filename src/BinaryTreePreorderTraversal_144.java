import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal_144 {
    private static class Solution {
        private static final List<Integer> list = new ArrayList<>();

        public List<Integer> preorderTraversal(TreeNode root) {
            list.clear();
            if (root != null) {
                elr(root);
            }
            return list;
        }

        private void elr(TreeNode node) {
            list.add(node.val);
            if (node.left != null) {
                elr(node.left);
            }
            if (node.right != null) {
                elr(node.right);
            }
        }
    }

    public static void main(String[] args) {
        var root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(new Solution().preorderTraversal(root));
    }
}
