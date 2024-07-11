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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
  
        ListNode prev = null;
        ListNode curr = head;
        ListNode forw = head.next;

        while(forw != null){
            if(curr.val == forw.val){
                if(prev != null){
                    prev.next = curr.next;
                }
                else{
                    head = forw;
                }
            }
            else{
                prev = curr;
            }
            curr = forw;
            forw = forw.next;
        }

        return head;
    }
}
