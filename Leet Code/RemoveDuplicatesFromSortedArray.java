class Solution {
    public int removeDuplicates(int[] nums) {
        int ind = 0;
        int n = nums.length;

        if(n == 0 )
            return 0;

        for(int j = 1; j < n; j++){
            if(nums[j] != nums[ind])
                nums[++ind] = nums[j];
        }
        
        return ind + 1;
    }
}
