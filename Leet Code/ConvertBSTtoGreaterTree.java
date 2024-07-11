/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode convertBST(TreeNode root) {
        int sum[] = new int[1];
        dfs(root, sum);
        return root;
    }

    private void dfs(TreeNode node, int sum[]){
        if(node == null){
            return;
        }
        dfs(node.right, sum);
        sum[0] += node.val;
        node.val = sum[0];
        dfs(node.left, sum);
    }
}
