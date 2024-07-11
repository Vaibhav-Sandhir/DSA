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
    public void flatten(TreeNode root) {
        postorder(root);
    }

    private TreeNode postorder(TreeNode node){
        if(node == null){
            return null;
        }
        if(isLeaf(node)){
            return node;
        }
        
        TreeNode l = postorder(node.left);
        TreeNode r = postorder(node.right);
        if(l != null){
            TreeNode temp = node.right;
            node.right = node.left;
            node.left = null;
            l.right = temp;
        }
        if(r == null){
            return l;
        }
        return r;
    }

    private boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }
}
