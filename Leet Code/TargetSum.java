class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
        }
        int[][] dp = new int[nums.length][(2 * sum)+ 1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return func(0, 0, target, nums, dp ,sum);
    }

    public int func(int i, int sum, int target, int[] nums, int[][] dp,int total){
        if(i == nums.length){
            if(sum == target)
                return 1;
            else
                return 0;    
        }

        if(dp[i][sum + total] != -1)
            return dp[i][sum + total];

        dp[i][sum + total] = func(i + 1, sum + nums[i], target, nums, dp, total) + func(i + 1, sum - nums[i], target, nums, dp, total);
        return dp[i][sum + total];
    }
}

// columns represent the current sum we are looking at so the range will be -total to +total so size will be 2 * total + 1
// and to handle -ve sums to access their index add total sum so -ve sums honge 0 se total and +ve sums honge total se 2 total
