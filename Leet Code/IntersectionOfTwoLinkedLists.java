public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA;
        ListNode currB = headB;
        int n = 0;
        int m = 0;
        int diff = 0;

        while(currA != null){
            n++;
            currA = currA.next;
        }
        while(currB != null){
            m++;
            currB = currB.next;
        }
        currA = headA;
        currB = headB;

        if(n > m){
            diff = n - m;
            for(int i = 0; i < diff; i++){
                currA = currA.next;
            }
        }
        else{
            diff = m - n;
            for(int i = 0; i < diff; i++){
                currB = currB.next;
            }
        }

        for(int i = 0; i < Math.max(m, n); i++){
            if(currA == currB)
                return currA;
            currA = currA.next;
            currB = currB.next;    
        }
        
        return null;
    }
}
