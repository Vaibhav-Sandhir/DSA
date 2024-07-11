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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode p = head;
        ListNode q = head.next;

        while(q != null){
            ListNode forw = q.next;
            prev.next = q;
            q.next = p;
            p.next = forw;
            if(forw == null)
                break;
            prev = p;
            p = forw;
            q = forw.next;
        }

        return dummy.next;
    }
}
