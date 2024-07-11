class Solution {
    int second_min = Integer.MAX_VALUE;
    boolean flag = false;
    public int findSecondMinimumValue(TreeNode root) {
            if(root == null || root.left == null && root.right == null)
                return -1;
            int min = root.val;
            find(root, min);
            if(second_min == Integer.MAX_VALUE && flag == false)
                return -1;
            else
                return second_min;        
    }

    public void find(TreeNode root, int min){
        if(root == null)
            return;

        if(root.val > min && root.val <= second_min){
            second_min = root.val;
            flag = true;
        }    

        find(root.left, min);
        find(root.right, min);        
    }
}
