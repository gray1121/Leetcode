


class Solution {
    // [1, 2, 3, 4, 5]  n = 5;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode n1 = head;
        ListNode n2 = dummy;
        for(int i = n; i > 0; i--) {
            if(n1 == null)   return head;
            n1 = n1.next;
        }
        while(n1 != null) {
            n1 = n1.next;
            n2 = n2.next;
        }
        n2.next = n2.next.next;
        return dummy.next;
    }
}