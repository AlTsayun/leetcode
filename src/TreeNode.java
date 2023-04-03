public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

//    public String toString()
//    {
//        var builder = new StringBuilder();
//        toString(this, 0, builder);
//        return builder.toString();
//    }
//
//    private void toString(TreeNode root, int offset, StringBuilder builder) {
//        var valStr = root.val + " -> ";
//        builder.append(valStr);
//        if (root.left != null) {
//            toString(root.left, valStr.length(), builder);
//        }
//        if (root.right != null) {
//            builder.append('\n');
//            builder.append(" ".repeat(valStr.length()));
//            toString(root.right, valStr.length(), builder);
//        }
//    }
//
//    public static void main(String[] args) {
//        var root = new TreeNode();
//        root.left = new TreeNode(1);
//        root.left.right = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(5);
//        System.out.println(root);
//    }
}