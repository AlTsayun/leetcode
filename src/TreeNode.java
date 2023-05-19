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

//    @Override
//    public String toString() {
//        var leftVal = left == null ? "null" : String.valueOf(left.val);
//        var rightVal = right == null ? "null" : String.valueOf(right.val);
//
//        var left = left == null
//        return val + " " + leftVal + " " + rightVal;
//    }
}