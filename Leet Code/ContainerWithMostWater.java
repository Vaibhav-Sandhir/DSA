class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max_area = 0;
        while(i != j){
            int min = minHeight(i,j,height);
            if(height[min] * (j - i) > max_area)
                max_area = height[min] * (j - i);
            if(min == j)
                j--;
            else
                i++;        
        }
        return max_area;
    }

    private int minHeight(int i, int j, int[] height){
        if(height[i] >= height[j])
            return j;
        return i;    
    }
}
