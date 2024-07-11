class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);
        ListNode leftNode = head;
        ListNode prevLeftNode = dummy;

        for(int i = 0; i < left - 1; i++){
            prevLeftNode = leftNode;
            leftNode = leftNode.next;
        }

        ListNode prev = null;
        ListNode curr = leftNode;
        int count = 1;

        while(count <= right - left + 1){
            ListNode ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
            count++;
        }

        leftNode.next = curr;  // curr is pointing one after right node;
        prevLeftNode.next = prev; // prev is at right node;

        return dummy.next;
    }
}
