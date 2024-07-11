class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int dp[] = new int[days.length];
        Arrays.fill(dp, -1);
        dp[0] = func(0, days, costs, dp);
        return dp[0];
    }

    private int func(int i, int[] days, int[] costs, int[] dp){
        if(i >= days.length){
            return 0;
        }
        if(dp[i] != -1)
            return dp[i];
        int i1 = i + 1;
        int i7 = i;
        int i30 = i;
        while (i7 < days.length && days[i7] < days[i] + 7) {
            i7++;
        }
        while (i30 < days.length && days[i30] < days[i] + 30) {
            i30++;
        }
        int a = costs[0] + func(i1, days, costs, dp);
        int b = costs[1] + func(i7, days, costs, dp);
        int c = costs[2] + func(i30, days, costs, dp);
        
        dp[i] = Math.min(Math.min(a, b), c);

        return dp[i];
    }
}
