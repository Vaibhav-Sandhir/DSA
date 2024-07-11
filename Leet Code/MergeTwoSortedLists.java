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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p = list1;
        ListNode q = list2;
        ListNode dummy = new ListNode(0);
        ListNode r = dummy;

        while(p != null && q != null){
            if(p.val <= q.val){
                r.next = p;
                p = p.next;
            }
            else{
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }

        if(p != null){
            while(p != null){
                r.next = p;
                p = p.next;
                r = r.next;
            }
        }
        if(q != null){
            while(q != null){
                r.next = q;
                q = q.next;
                r = r.next;
            }
        }

        return dummy.next;
    }
}
