import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal_94 {
    private static class Solution {
        private static final List<Integer> list = new ArrayList<>();

        public List<Integer> inorderTraversal(TreeNode root) {
            list.clear();
            if (root != null) {
                ler(root);
            }
            return list;
        }

        private void ler(TreeNode node) {
            if (node.left != null) {
                ler(node.left);
            }
            list.add(node.val);
            if (node.right != null) {
                ler(node.right);
            }
        }
    }

    public static void main(String[] args) {
        var root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(new Solution().inorderTraversal(root));
    }
}
