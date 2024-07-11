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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode prev = null;
        ListNode mid = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            prev = mid;
            mid = mid.next;
            fast = fast.next.next;
        }
        prev.next = null;

        head = sortList(head);
        mid = sortList(mid);
        return mergeList(head, mid);
    }

    private ListNode mergeList(ListNode head, ListNode mid){
        ListNode dummy = new ListNode(0);
        ListNode r = dummy;
        ListNode p = head;
        ListNode q = mid;

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
