class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int ans = 0;

        for(int i : nums){
            int freq = map.getOrDefault(i, 0) + 1;
            maxFreq = Math.max(freq, maxFreq);
            map.put(i, freq);
        }

        int dp[] = new int[maxFreq + 1];
        Arrays.fill(dp, 1);

        for(int i = 4; i < dp.length; i++){
            dp[i] = 1 + Math.min(dp[i - 3], dp[i - 2]);   
        }

        for(int freq : map.values()){
            if(freq <= 1){
                return -1;
            }
            ans += dp[freq];
        }

        return ans;
    }
}
