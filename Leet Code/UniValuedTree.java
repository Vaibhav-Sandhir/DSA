class Solution {
    public boolean isUnivalTree(TreeNode root) {
        int num = root.val;
        
        return isUni(root, num);
    }

    public boolean isUni(TreeNode node, int num){
        if(node == null)
            return true;
        return node.val == num && isUni(node.left, num) && isUni(node.right, num);
    }
}
