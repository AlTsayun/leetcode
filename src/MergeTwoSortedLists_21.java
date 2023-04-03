public class MergeTwoSortedLists_21 {
    static class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            var head = new ListNode();
            var node = head;
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    node.next = list1;
                    list1 = list1.next;
                } else {
                    node.next = list2;
                    list2 = list2.next;
                }
                node = node.next;
            }
            while (list1 != null) {
                node.next = list1;
                list1 = list1.next;
                node = node.next;
            }
            while (list2 != null) {
                node.next = list2;
                list2 = list2.next;
                node = node.next;
            }
            return head.next;
        }
    }

    public static void main(String[] args) {
        var head1 = ListNode.createNodes(1,2,3,4,5);
        var head2 = ListNode.createNodes(1,2,3,4,5);
//        System.out.println(new Solution().mergeTwoLists(head1, head2));
        head1 = ListNode.createNodes(-9, 3);
        head2 = ListNode.createNodes(5, 7);
        System.out.println(new Solution().mergeTwoLists(head1, head2));
    }
}
