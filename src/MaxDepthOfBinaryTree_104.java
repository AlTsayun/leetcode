import java.util.ArrayDeque;
import java.util.Queue;

public class MaxDepthOfBinaryTree_104 {
    private static class Solution {
        public int maxDepth(TreeNode root) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            int maxDepth = 0;
            if (root != null) {
                queue.add(root);
                while (!queue.isEmpty()) {
                    int levelSize = queue.size();
                    for (int i = 0; i < levelSize; i++) {
                        if (queue.peek().left != null) {
                            queue.add(queue.peek().left);
                        }
                        if (queue.peek().right != null) {
                            queue.add(queue.peek().right);
                        }
                        queue.remove();
                    }
                    maxDepth++;
                }
            }
            return maxDepth;
        }
    }

    public static void main(String[] args) {
        var root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(new Solution().maxDepth(root));
    }
}
