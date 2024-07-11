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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode curr = head;
        ListNode right = head;
        ListNode prev = dummy;

        outerLoop: while(true){
            int count = k;
            while(count > 0){
                if(right == null){
                    break outerLoop;
                }
                right = right.next;
                count--;
            }
            ListNode tmp_head = curr;
            while(curr != right){
                ListNode forw = curr.next;
                curr.next = prev;
                prev = curr;
                curr = forw;
            }
            tmp_head.next = right;
            left.next = prev;
            left = tmp_head;
            prev = left;
        }

        return dummy.next;
    }
}
