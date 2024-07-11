class Solution {
    public int minSubArrayLen(int target, int[] nums) {
       int left = 0;
       int right = 0;
       int n = nums.length;
       int sum = 0;
       int size = n;
       boolean flag = false;

       while(right < n){
            sum += nums[right];
            while(sum >= target){
                flag = true;
                size = Math.min(size, right - left + 1);
                sum = sum - nums[left];
                left++;
            }
            right++;
       }
        if(flag)
            return size;
        else
            return 0;    
    }
}
