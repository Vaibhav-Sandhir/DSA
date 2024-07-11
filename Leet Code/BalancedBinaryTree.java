class Solution {
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        balanceFactor(root);
        return flag;
    }

    public void balanceFactor(TreeNode node){
        if(node == null)
            return;

        int ans = height(node.left) - height(node.right);
        if(ans < -1 || ans > 1){
            flag = false;
            return;
        }
        balanceFactor(node.left);
        balanceFactor(node.right);
    }

    public int height(TreeNode node){
        if(node == null)
            return 0;

        return 1 + Math.max(height(node.right), height(node.left));    
    }
}
