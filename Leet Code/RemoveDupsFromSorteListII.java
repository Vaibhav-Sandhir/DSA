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

        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy.next;
        ListNode prev = dummy;

        while(curr != null && curr.next != null){
            if(curr.val == curr.next.val){
                int num = curr.val;
                while(curr != null && curr.val == num){
                    curr = curr.next;
                }
                prev.next = curr;
            }
            else{
                prev = curr;
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}
