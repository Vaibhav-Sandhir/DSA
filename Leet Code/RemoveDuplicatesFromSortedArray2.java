class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int ind = 0;
        int n = nums.length;

        if(n == 0)
            return 0;

        for(int j = 1; j < n; j++){
            
            if(nums[j] == nums[ind] && count < 2){
                nums[++ind] = nums[j];
                count++;
            }

            else if(nums[j] != nums[ind]){
                nums[++ind] = nums[j];
                count = 1;
            }
        }

        return ind + 1;
    }
}
