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
    public ListNode insertionSortList(ListNode head) {
       if(head == null){
           return head;
       }
       
       ListNode dummy = new ListNode(0, head);
       ListNode prev_to_curr = head;
       ListNode curr = head.next;
       while(curr != null){
           ListNode pos = dummy.next;
           ListNode prev_to_pos = dummy;
           ListNode forw = curr.next;
           while(pos.val <= curr.val && pos != curr){
               prev_to_pos = pos;
               pos = pos.next;
           }
           if(curr == pos){
               prev_to_curr = curr;
               curr = forw;
               continue;
           }
           prev_to_pos.next = curr;
           curr.next = pos;
           prev_to_curr.next = forw;
           curr = forw;
       }

       return dummy.next;
    }
}
