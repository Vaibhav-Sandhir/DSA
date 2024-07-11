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
    public ListNode middleNode(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode p = dummy;
        ListNode q = dummy;

        while(q != null){
            if(q.next == null){
                return p.next;
            }
            q = q.next;
            q = q.next;
            p = p.next;
        }

        return p;
    }
}
