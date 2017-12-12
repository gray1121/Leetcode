// HashMap
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) { return null; }
        RandomListNode r = head;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (r != null) {
            map.put(r, new RandomListNode(r.label));
            r = r.next;
        }
        r = head;
        while (r != null) {
            map.get(r).next = map.get(r.next);
            map.get(r).random = map.get(r.random);
            r = r.next;
        }
        return map.get(head);
    }
}
// O(1) Space
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return head;
        RandomListNode point = head;
        while(point != null) {
            RandomListNode next = point.next;
            RandomListNode copy = new RandomListNode(point.label);
            copy.next = next;
            point.next = copy;
            point = next;
        }
        point = head;
        while(point != null) {
            RandomListNode copy = point.next;
            copy.random = point.random == null ? null : point.random.next;
            point = point.next.next;
        }
        point = head;
        RandomListNode res = point.next;
        while(point != null) {
            RandomListNode next = point.next;
            point.next = next.next;
            point = point.next;
            next.next = point == null ? null : point.next;
        }
        return res;
    }
}