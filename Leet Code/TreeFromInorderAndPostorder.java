class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        for(int i : inorder)
            in.add(i);
        for(int i : postorder)
            post.add(i);

        return makeTree(in, post);        
    }

    public TreeNode makeTree(List<Integer> in, List<Integer> post){
        if(in.isEmpty())
            return null;

        TreeNode root = new TreeNode(post.remove(post.size() - 1));
        int mid = in.indexOf(root.val);
        root.right = makeTree(in.subList(mid + 1, in.size()), post);
        root.left = makeTree(in.subList(0, mid), post);
        return root;
    }
}
