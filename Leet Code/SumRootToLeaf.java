class Solution {
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    private int sum(TreeNode node, int sum){
        if(node == null)
            return 0;

        sum = sum * 10 + node.val;

        if(node.left == null && node.right == null)
            return sum;
        
        return sum(node.left, sum) + sum(node.right, sum);            
    }
}
