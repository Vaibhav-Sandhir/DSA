class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int index[] = new int[]{0};
        return inorder(root, k, index);
    }

    public int inorder(TreeNode root, int k, int index[]){
        if(root == null)
            return 0;

        int left = inorder(root.left, k, index);

        if(left != 0)
            return left;
        index[0]++;
        if(index[0] == k){
            return root.val;
        }
        return inorder(root.right, k, index);   
    }
}
