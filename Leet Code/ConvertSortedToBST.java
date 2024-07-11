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
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        int middle = n / 2;
        TreeNode root = new TreeNode(nums[middle]);
        makeTree(root, 0, middle - 1, nums);
        makeTree(root, middle + 1, n - 1, nums);
        return root;
    }

    public void makeTree(TreeNode root, int start, int end, int nums[]){
        if(start > end)
            return;

        if(root == null)
            return;    

        int middle = (end + start + 1) / 2;

        TreeNode node = new TreeNode(nums[middle]);
        if(nums[middle] > root.val)
            root.right = node;
        else
            root.left = node;

        makeTree(node, start, middle - 1, nums);
        makeTree(node, middle + 1, end, nums);        
    }
}
