class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(char c : word.toCharArray()){
            if(!node.children.containsKey(c)){
                Node child = new Node();
                node.children.put(c, child);
                node = child;
            }
            else{
                node = node.children.get(c);
            }
        }
        node.endOfWord = true;
    }
    
    public boolean search(String word) {
        Node node = root;
        for(char c : word.toCharArray()){
            if(!node.children.containsKey(c)){
                return false;
            }
            else{
                node = node.children.get(c); 
            }
        }

        return node.endOfWord;
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for(char c : prefix.toCharArray()){
            if(!node.children.containsKey(c)){
                return false;
            }
            else{
                node = node.children.get(c);
            }
        }

        return true;
    }
}

class Node{
    Map<Character, Node> children;
    boolean endOfWord;

    public Node(){
        children = new HashMap<>();
        this.endOfWord = endOfWord;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
