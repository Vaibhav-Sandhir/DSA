class Solution {
    private int xDepth;
    private int yDepth;
    private TreeNode xParent;
    private TreeNode yParent;   
    
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, x, y, 0);
        return xDepth == yDepth && xParent != yParent;
    }

    public void dfs(TreeNode node, TreeNode parent, int x, int y, int depth){
        if(node == null || (xParent != null && yParent != null))
            return;

        if(node.val == x){
            xDepth = depth;
            xParent = parent;
        }

        if(node.val == y){
            yDepth = depth;
            yParent = parent;
        }

        dfs(node.left, node, x, y, depth + 1);
        dfs(node.right, node, x, y, depth + 1);    
    }
}
