import org.jetbrains.annotations.NotNull;

import java.util.ArrayDeque;

public class PopulatingNextRightPointersInEachNode_116 {
    private static class Solution {

        public Node connectInDepth(Node root) {
            if(root == null) {
                return null;
            }
            if(root.left != null) {
                root.left.next = root.right;
                if(root.next != null) {
                    root.right.next = root.next.left;
                }
                connectInDepth(root.left);
                connectInDepth(root.right);
            }
            return root;
        }

        public Node connect(Node root) {
            if(root == null) return null;
            var queue = new ArrayDeque<Node>();
            queue.offer(root);
            while(!queue.isEmpty()) {
                Node nodeToTheRight = null;
                var levelSize = queue.size();
                for(int i = 0; i < levelSize; i++) {
                    Node cur = queue.poll();
                    cur.next = nodeToTheRight;
                    nodeToTheRight = cur;
                    if(cur.right != null) {
                        queue.offer(cur.right);
                        queue.offer(cur.left);
                    }
                }
            }
            return root;
        }
    }

    public static void main(String[] args) {
        var root = createTree();
        System.out.println(new Solution().connect(root));
        root = createTree();
        System.out.println(new Solution().connectInDepth(root));
    }

    @NotNull
    private static Node createTree() {
        var root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        return root;
    }
}
