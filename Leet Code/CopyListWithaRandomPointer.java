/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node p = head;
        while(p != null){
            Node node = new Node(p.val);
            map.put(p, node);
            p = p.next;
        }
        
        p = head;
        while(p != null){
            Node node = map.get(p);
            node.next = map.get(p.next);
            node.random = map.get(p.random);
            p = p.next;
        }

        return map.get(head);
    }
}
