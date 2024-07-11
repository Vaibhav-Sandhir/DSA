class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max_sum = nums[0];
        int curr_sum = 0;
        int left = 0;
        int right = 0;
        
        while(right < n){
            curr_sum += nums[right];
            max_sum = Math.max(curr_sum, max_sum);
            if(curr_sum < 0){
                curr_sum = 0;
                left = right + 1;
            }
            right++;
        }

        return max_sum;
    }
}
