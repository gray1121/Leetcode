// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}

// Definition for double-linked list

class DLinkedNode {
    int key;
    int value;
    DLinkedNode pre;
    DlinkedNode post;
}

// Dummy Node
// Head may be changed 

ListNode dummy = new ListNode(0);
dummy.next = head;
head = dummy;
ListNode prev = dummy;
ListNode curt = head;

// Reverse 
public class Solution {
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
}

// Find_Mid
public ListNode findMid(ListNode head){
    ListNode slow = head, fast = head.next;
    while(fast != null && fast.next != null){
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
} 