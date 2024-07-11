class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        int n = nums.length;
        int ind = n - 1;

        for(int i = 0; i < n; i++){
            if(nums[i] == val){
                count = count + 1;
            }
        }

        for(int i = 0; i < n && ind > i; i++){
            if(nums[i] == val){
                while(ind > 0 && nums[ind] == val && ind > i)
                    ind--;
                int temp = nums[i];
                nums[i] = nums[ind];
                nums[ind--] = temp;
            }
        }
        return n - count;
    }
}
