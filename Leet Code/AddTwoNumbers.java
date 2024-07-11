class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var curr1 = l1;
        var curr2 = l2;
        int carry = 0;
        ListNode l3 = new ListNode((l1.val + l2.val) % 10);
        var curr = l3;
        if(l1.val + l2.val >= 10)
            carry = 1;
        l1 = l1.next;
        l2 = l2.next;
        int sum = 0;
        while(l1 != null || l2 != null){
            if(l1 == null){
                sum = l2.val + carry;
                l2 = l2.next;
            }
            else if(l2 == null){
                sum = l1.val + carry;
                l1 = l1.next;
            }
            else{
                sum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }
            if(sum >= 10)
                carry = 1;
            else
                carry = 0;      
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }
        if(carry == 1)
            curr.next = new ListNode(carry);
        return l3;
    }
}
