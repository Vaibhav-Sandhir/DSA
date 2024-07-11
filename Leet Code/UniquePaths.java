class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for(int[] arr : dp)
            Arrays.fill(arr, -1);
        paths(0, 0, m, n, dp);
        return dp[0][0];
    }

    public int paths(int i, int j, int m, int n, int[][] dp){
        if(i >= m || j >= n)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];    
        if(i == m - 1 && j == n - 1)
            return 1;
        dp[i][j] = paths(i + 1, j, m, n, dp) + paths(i, j + 1, m, n, dp);
        return dp[i][j];        
    }
