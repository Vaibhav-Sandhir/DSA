class Solution {
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        TreeNode root1 = new TreeNode(list.get(0));
        TreeNode cpy = root1;
        for(int i = 1; i < list.size(); i++){
            TreeNode r = new TreeNode(list.get(i));
            cpy.right = r;
            cpy = r;  
        }
        return root1;
    }

    public void inorder(TreeNode node, List<Integer> list){
        if(node == null)
            return;

        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
}
