/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return next == null ? Integer.toString(val) : val + " -> " + next;
    }

    public static ListNode createNodes(int... numbers) {
        ListNode root = new ListNode();
        ListNode curr = root;
        for (int number : numbers) {
            curr.next = new ListNode(number);
            curr = curr.next;
        }
        return root.next;
    }
}
