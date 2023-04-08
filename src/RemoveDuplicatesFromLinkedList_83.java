public class RemoveDuplicatesFromLinkedList_83 {
    private static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            var node =  head;
            while (node != null && node.next != null) {
                if (node.val == node.next.val) {
                    node.next = node.next.next;
                } else {
                    node = node.next;
                }
            }
            return head;
        }
    }

    public static void main(String[] args) {
        var head = ListNode.createNodes(1, 1, 2, 3, 3, 4, 5, 5);
        System.out.println(new Solution().deleteDuplicates(head));
    }
}
