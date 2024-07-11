class Solution {
    int max_freq = 1;
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        count(root, map);

        for(int key : map.keySet()){
            if(map.get(key) == max_freq)
                list.add(key);
        }
        int ans[] = new int[list.size()];
        for(int i = 0 ; i < list.size(); i++)
            ans[i] = list.get(i);
        return ans;    
    }
    public void count(TreeNode node, HashMap<Integer, Integer> map){
        if(node == null)
            return;

        if(map.containsKey(node.val)){
            int freq = map.get(node.val);
            map.put(node.val, freq + 1);
            max_freq = Math.max(max_freq, freq + 1);
        }    
        else{
            map.put(node.val, 1);
        }
        count(node.right, map);
        count(node.left, map);
    }
}
