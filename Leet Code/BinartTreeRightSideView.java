class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        queue.add(root);

        while(!queue.isEmpty()){
            int n = queue.size();

            for(int i = 0; i < n; i++){
                TreeNode node = queue.remove();
                list.add(node.val);

                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)    
                    queue.add(node.right);
            }
            ans.add(list.get(list.size() - 1));
            list.clear();
        }

        return ans;
    }
}
