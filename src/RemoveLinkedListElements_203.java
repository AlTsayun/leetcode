public class RemoveLinkedListElements_203 {
    static class Solution {
        public ListNode removeElements(ListNode head, int val) {
            var preHead = new ListNode();
            preHead.next = head;
            var node = preHead;
            while(node.next != null) {
                if (node.next.val == val) {
                    node.next = node.next.next;
                } else {
                    node = node.next;
                }
            }
            return preHead.next;
        }
    }

    public static void main(String[] args) {
        var head = ListNode.createNodes(1,2,3,4,5);
        System.out.println(new Solution().removeElements(head, 3));
        head = ListNode.createNodes(1,2,3,4,5);
        System.out.println(new Solution().removeElements(head, 5));
        head = ListNode.createNodes(-9, 3);
        System.out.println(new Solution().removeElements(head, 0));
    }
}
