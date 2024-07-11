class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        queue.add(root);

        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < n; i++){
                TreeNode node = queue.remove();
                level.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)    
                    queue.add(node.right);
            }
            result.add(level);
        }
        return result;
    }
}
