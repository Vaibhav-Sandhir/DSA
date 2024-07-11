class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int arr[] = jobDifficulty;
        int n = arr.length;
        int dp[][][] = new int[n][d+1][1001];
        for(int a[][] : dp){
            for(int b[] : a){
                Arrays.fill(b, -1);
            }
        }

        if(d > n){
            return -1;
        }

        return func(0, d, 0, arr, dp);
    }

    private int func(int i, int d, int dayMax, int arr[], int dp[][][]){
        if(i == arr.length){
            return (d == 0) ? 0 : 10000000;
        }
        if(d == 0){
            return 10000000;
        }
        if(dp[i][d][dayMax] != -1){
            return dp[i][d][dayMax];
        }

        dayMax = Math.max(arr[i], dayMax);
        int end = dayMax + func(i + 1, d - 1, 0, arr, dp);
        int not_end = func(i + 1, d, dayMax, arr, dp);

        dp[i][d][dayMax] = Math.min(end, not_end);
        return dp[i][d][dayMax];

    }
}
