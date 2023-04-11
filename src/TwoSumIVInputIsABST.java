import java.util.ArrayDeque;
import java.util.Deque;

public class TwoSumIVInputIsABST {
    private static class Solution {
        public boolean findTarget(TreeNode root, int k) {
            if (root == null) {
                return false;
            }
            Deque<Integer> deque = new ArrayDeque<>();
            ler(root, deque);

            while (deque.size() > 1) {
                var sum = deque.peekFirst() + deque.peekLast();
                if (sum == k) {
                    return true;
                }
                if (sum > k) {
                    deque.pollFirst();
                }
                if (sum < k) {
                    deque.pollLast();
                }
            }

            return false;
        }

        private void ler(TreeNode node, Deque<Integer> deque)  {
            if (node.left != null) {
                ler(node.left, deque);
            }
            deque.push(node.val);
            if (node.right != null) {
                ler(node.right, deque);
            }
        }
    }

    public static void main(String[] args) {
//        var root = new TreeNode(5);
//        root.left = new TreeNode(3);
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(4);
//        root.right = new TreeNode(6);
//        root.right.right = new TreeNode(7);
//        System.out.println(new Solution().findTarget(root, 9));

        var root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(new Solution().findTarget(root, 3));
    }
}
