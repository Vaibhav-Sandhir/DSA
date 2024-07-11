class WordDictionary {
    Node root;
    
    public WordDictionary() {
        root = new Node();    
    }
    
    public void addWord(String word) {
        Node node = root;
        for(char c : word.toCharArray()){
            if(!node.children.containsKey(c)){
                node.children.put(c, new Node());
            }
            node = node.children.get(c);
        }
        node.endOfWord = true;
    }
    
    public boolean search(String word) {
        char arr[] = word.toCharArray();
        return dfs(0, arr, root);
    }

    private boolean dfs(int i, char arr[], Node node){
        Node curr = node;

        for(int j = i; j < arr.length; j++){
            
            if(arr[j] == '.'){
                for(Node n : curr.children.values()){
                    if(dfs(j + 1, arr, n)){
                        return true;
                    }
                }
                return false;
            }
            else{
                if(!curr.children.containsKey(arr[j])){
                    return false;
                }
                curr = curr.children.get(arr[j]);
            }
        }
        return curr.endOfWord;
    }
}

class Node{
    Map<Character, Node> children;
    boolean endOfWord;

    public Node(){
        children = new HashMap<>();
        endOfWord = false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
