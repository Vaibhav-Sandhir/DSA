class Solution {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        return func(root, 1);
    }

    public int func(TreeNode node, int depth){
        if(node == null)
            return 10001;
        if(node.right == null & node.left == null)
            return depth;    

        return Math.min(func(node.right, depth + 1), func(node.left, depth + 1));    
    }
}
