class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int ans[] = {0};
        postorder(root, ans);
        return ans[0];
    }

    private int postorder(TreeNode root, int ans[]){
        if(root == null)
            return -1;

        int leftHeight = postorder(root.left, ans);
        int rightHeight = postorder(root.right, ans);

        ans[0] = Math.max(ans[0], 2 + leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);    
    }
}
