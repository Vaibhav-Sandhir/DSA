class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        getLeaves(root1, list1);
        getLeaves(root2, list2);
        if(list1.size() != list2.size())
            return false;
        for(int i = 0; i < list1.size(); i++){
            if(list1.get(i).val != list2.get(i).val)
                return false;
        }
        return true;    
    }

    public void getLeaves(TreeNode node, List<TreeNode> list){
        if(node == null)
            return;
        if(node.right == null && node.left == null)
            list.add(node);
        getLeaves(node.left, list);
        getLeaves(node.right, list);        
    }
}
