import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal_102 {
    private static class Solution {
        private static final List<List<Integer>> list = new ArrayList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {
            list.clear();
            if (root != null) {
                elr(root, 0);
            }
            return list;
        }

        private void elr(TreeNode node, int level) {
            insertAtLevel(node.val, level);
            if (node.left != null) {
                elr(node.left, level + 1);
            }
            if (node.right != null) {
                elr(node.right, level + 1);
            }
        }

        private void insertAtLevel(int val, int level) {
            if (level > list.size() - 1) {
                list.add(new ArrayList<>());
            }
            list.get(level).add(val);
        }
    }

    public static void main(String[] args) {
        var root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Solution().levelOrder(root));
    }
}
