class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n == 0)
            return 0;
        int left = 0;
        int right = n - 1;
        int left_max_height = height[left];
        int right_max_height = height[right];
        int total = 0;

        while(left < right){
            if(left_max_height < right_max_height){
                left++;
                left_max_height = Math.max(left_max_height, height[left]);
                total += left_max_height - height[left];
            }

            else{
                right--;
                right_max_height = Math.max(right_max_height, height[right]);
                total += right_max_height - height[right];
            }
        }

        return total;    
    }
}
