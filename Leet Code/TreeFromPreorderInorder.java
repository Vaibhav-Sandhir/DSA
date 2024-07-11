class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        for(int i: preorder)
            pre.add(i);
        for(int i : inorder)
            in.add(i);

        return makeTree(pre, in);            
    }

    public TreeNode makeTree(List<Integer> pre, List<Integer> in){
        if(pre.isEmpty() || in.isEmpty())
            return null;

        TreeNode root = new TreeNode(pre.get(0));
        int mid = in.indexOf(root.val);
        root.left = makeTree(pre.subList(1, mid + 1), in.subList(0, mid));
        root.right = makeTree(pre.subList(mid + 1, pre.size()), in.subList(mid + 1, in.size()));
        return root;     
    }
}
