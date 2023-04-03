public class ReverseLinkedList_206 {
    static class Solution {
        public ListNode reverseList(ListNode head) {
            var node = new ListNode();
            while (head != null) {
                var tmp = head.next;
                head.next = node.next;
                node.next = head;
                head = tmp;
            }
            return node.next;
        }
    }

    public static void main(String[] args) {
        var head = ListNode.createNodes(1,2,3,4,5);
        System.out.println(new Solution().reverseList(head));
        head = ListNode.createNodes(-9, 3);
        System.out.println(new Solution().reverseList(head));
        head = ListNode.createNodes(5, 7);
        System.out.println(new Solution().reverseList(head));
        head = ListNode.createNodes();
        System.out.println(new Solution().reverseList(head));
    }
}
