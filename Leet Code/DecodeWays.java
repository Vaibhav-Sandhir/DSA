class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        char[] array = s.toCharArray();

        for(int i = n - 1; i >= 0; i--){
            if(array[i] == '0')
                dp[i] = 0;
            else
                dp[i] = dp[i + 1];
 
            if(i + 1 < n && (array[i] == '1' || (array[i] == '2' && array[i + 1] >= '0' && array[i + 1] <= '6'))){
                dp[i] += dp[i + 2];
            }        
        }

        return dp[0]; 
    }
}
