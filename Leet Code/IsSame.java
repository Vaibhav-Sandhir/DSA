class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSame(p, q);
    }

    public boolean isSame(TreeNode p, TreeNode q){
        if(p == null && q == null)
            return true;
        if(p == null)
            return false;
        if(q == null)
            return false;        
        return isSame(p.right, q.right) && isSame(p.left, q.left) && p.val == q.val;
    }
}
