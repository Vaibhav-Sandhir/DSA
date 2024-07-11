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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        List<ListNode> lists1 = new ArrayList<>(Arrays.asList(lists)); 
        

        while(lists1.size() > 1){
            List<ListNode> mergedLists = new ArrayList<>();

            for(int i = 0; i < lists1.size(); i = i + 2){
                ListNode l1 = lists1.get(i);
                ListNode l2 = (i + 1 < lists1.size()) ? lists1.get(i + 1) : null;
                mergedLists.add(merge(l1, l2));
            }
            lists1 = mergedLists;
        }

        return lists1.get(0);
    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode r = dummy;
        
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                r.next = l1;
                l1 = l1.next;
            }
            else{
                r.next = l2;
                l2 = l2.next;
            }
            r = r.next;
        }

        if(l1 != null){
            while(l1 != null){
                r.next = l1;
                l1 = l1.next;
                r = r.next;
            }
        }
        if(l2 != null){
            while(l2 != null){
                r.next = l2;
                l2 = l2.next;
                r = r.next;
            }
        }

        return dummy.next;
    }
}
