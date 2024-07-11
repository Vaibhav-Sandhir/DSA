class Solution {
    public int rob(TreeNode root) {
        int[] list = postorder(root);
        return Math.max(list[0], list[1]);
    }

    private int[] postorder(TreeNode root){
        if(root == null)
            return new int[]{0, 0};

        int[] left = postorder(root.left);
        int[] right = postorder(root.right);

        int withRoot = root.val + left[1] + right[1];
        int withoutRoot = max(left[0], left[1]) + max(right[0], right[1]);

        return new int[]{withRoot, withoutRoot};    
    }

    private int max(int a, int b){
        if(a > b)
            return a;
        else
            return b;    
    }
}
