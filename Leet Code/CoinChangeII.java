class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length][amount];
        for(int arr[] : dp)
            Arrays.fill(arr, -1);
        return func(0, 0, amount, coins, dp);
    }

    private int func(int ind, int sum, int amount, int[] coins, int[][] dp){
        if(sum == amount)
            return 1;
        if(sum > amount)
            return 0;
        if(ind >= coins.length)
            return 0;    
        if(dp[ind][sum] != -1)
            return dp[ind][sum];
        
        dp[ind][sum] = func(ind, sum + coins[ind], amount, coins, dp) +
                       func(ind + 1, sum, amount, coins, dp); 
        return dp[ind][sum];        
    }
}
