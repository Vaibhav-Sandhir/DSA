public class Codec {
    public String make(TreeNode root) {
        StringBuilder buffer = new StringBuilder();
        if (root == null){
            return "# ";
        }
        buffer.append(String.valueOf(root.val) + " ");
        buffer.append(make(root.left));
        buffer.append(make(root.right));
        return buffer.toString();
    }

    public String serialize(TreeNode root) {
        String ans = make(root);
        return ans;
    }

    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(" ")));
        return helper(queue);
    }
    
    private TreeNode helper(Queue<String> queue) {
        String s = queue.poll();
        if (s.equals("#")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = helper(queue);
        root.right = helper(queue);
        return root;
    }
}
