class Solution {
    boolean ans = false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        compare(root, subRoot);
        return ans;        
    }

    public void compare(TreeNode root, TreeNode subRoot){
        if(root == null)
            return;
        if(root.val == subRoot.val)
            ans = ans || isSame(root, subRoot); // beacuse multiple calls but ek baar bhi true then retain

        compare(root.left, subRoot);
        compare(root.right, subRoot);    
    }

    public boolean isSame(TreeNode node, TreeNode subRoot){
        if(node == null && subRoot == null)
            return true;
        if(node == null || subRoot == null)
            return false;    
        return node.val == subRoot.val && isSame(node.left, subRoot.left) && isSame(node.right, subRoot.right);
    }
}
