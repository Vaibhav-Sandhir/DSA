class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode node = stack.pop();
        TreeNode curr = node.right;
        while(curr != null){
            stack.push(curr);
            curr = curr.left;
        }

        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
