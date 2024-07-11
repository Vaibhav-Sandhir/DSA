/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode p = dummy;
        ListNode prev = null;
        ListNode q = dummy;

        while(q != null){
            if(q.next == null){
                prev = p;
                prev.next = p.next.next;
                return dummy.next;
            }
            q = q.next.next;
            prev = p;
            p = p.next;
        }

        prev.next = p.next;
        return dummy.next;
    }
}
