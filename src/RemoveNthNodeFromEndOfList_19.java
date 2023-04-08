import java.util.HashMap;

public class RemoveNthNodeFromEndOfList_19 {
    private static class Solution {
        public ListNode removeNthFromEnd2(ListNode head, int n) {
            var preHead = new ListNode();
            preHead.next = head;
            var map = new HashMap<Integer, ListNode>();
            map.put(-1, preHead);
            int i = 0;
            var node = preHead;
            while (node.next != null) {
                map.put(i, node.next);
                i++;
                node = node.next;
            }
            var precedingToRemove = map.get(i - n - 1);
            remove(precedingToRemove);
            return preHead.next;
        }

        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode preHead = new ListNode();
            preHead.next = head;
            ListNode slow = preHead;
            ListNode fast = preHead;
            for (int i = 0; i < n; i++) {
                fast = fast.next;
            }
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            remove(slow);
            return preHead.next;
        }

        public void remove(ListNode preceding) {
            preceding.next = preceding.next.next;
        }
    }

    public static void main(String[] args) {
        var head = ListNode.createNodes(1,2,3,4,5);
        System.out.println(new Solution().removeNthFromEnd(head, 5));
        System.out.println(new Solution().removeNthFromEnd2(head, 4));
    }
}
