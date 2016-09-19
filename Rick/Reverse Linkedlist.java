public class Solution{
    public ListNode reverseList(ListNode head){
        ListNode res = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = res;
            res = head;
            head = temp;
        }
        return res;
    }
    


    public ListNode reverseBetween(ListNode head, int m, int n){
        if(null == head || m >= n) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        for(int i = 1; i < m; ++i)
            head = head.next;
        ListNode prev = head;
        head = head.next;
        ListNode end = head;
        ListNode res = null;
        for(int i = m; i <= n; ++i){
            ListNode temp = head.next;
            head.next = res;
            res = head;
            head = temp;
        }
        end.next = head;
        prev.next = res;
        return dummy.next;
    }



    
    public void reorderList(ListNode head) {
        // find the mid of this List
        if(null == head || null == head.next)
            return;
        ListNode p1 = head, p2 = head.next;
        while(p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        
        // reverse half of the List
        ListNode mid = p1;
        ListNode curt = p1.next;
        ListNode res = null;
        while(curt != null){
            ListNode temp = curt.next;
            curt.next = res;
            res = curt;
            curt = temp;
        }
        mid.next = res;
        
        // reorder this new list
        p1 = head;
        p2 = mid.next;
        while(p1 != mid){
            mid.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = mid.next;
        }
    }
}