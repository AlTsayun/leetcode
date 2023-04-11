import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph_133 {

    // Definition for a Node.
    private static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    private static class Solution {

        private final Map<Integer, Node> map = new HashMap<>();

        public Node cloneGraph(Node node) {
            if (node == null) {
                return null;
            }
            if (map.containsKey(node.val)) {
                return map.get(node.val);
            }
            var newNode = new Node(node.val);
            map.put(node.val, newNode);
            for (Node neighbor : node.neighbors) {
                newNode.neighbors.add(cloneGraph(neighbor));
            }
            return newNode;
        }
    }

    public static void main(String[] args) {
        var node1 = new Node(1);
        var node2 = new Node(2);
        var node3 = new Node(3);
        var node4 = new Node(4);

        node1.neighbors = List.of(node2, node4);
        node2.neighbors = List.of(node1, node3);
        node3.neighbors = List.of(node2, node4);
        node4.neighbors = List.of(node1, node3);

        var node = new Solution().cloneGraph(node1);
    }
}
