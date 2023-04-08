public class LinkedListCycle_141 {
    private static class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) {
                return false;
            }

            var fast = head;
            var slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        var head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;
        System.out.println(new Solution().hasCycle(head));

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head;
        System.out.println(new Solution().hasCycle(head));

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println(new Solution().hasCycle(head));

        head = new ListNode(1);
        System.out.println(new Solution().hasCycle(head));
    }
}
