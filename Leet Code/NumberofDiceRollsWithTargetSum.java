class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int dp[][] = new int[n + 1][target + 1];

        if(n == 1){
            if(k >= target){
                return 1;
            }
            else{
                return 0;
            }
        }
        
        for(int i = 1; i <= k && i < target; i++){
            dp[1][i] = 1;
        }

        for(int dices = 2; dices <= n; dices++){
            for(int num = 1; num <= target; num++){
                for(int i = 1; i <= Math.min(num, k); i++){
                    dp[dices][num] = (dp[dices][num] + dp[dices - 1][num - i]) % (int)(Math.pow(10, 9) + 7);
                }
            }
        }

        return dp[n][target];
    }
}
