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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode mid = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            mid = mid.next;
        }

        ListNode curr = mid;
        ListNode prev = null;

        while(curr != null){
            ListNode forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }

        ListNode p = head;
        ListNode q = prev;

        while(p != mid){
            ListNode forw1 = p.next;
            ListNode forw2 = q.next;
            p.next = q;
            if(q == forw1){
                break;
            }
            q.next = forw1;
            q = forw2;
            p = forw1;
        }

    }
}
