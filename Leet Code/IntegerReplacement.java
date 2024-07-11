class Solution {
    public int integerReplacement(int n) {
        Map<Integer, Integer> dp = new HashMap<>();
        return func(n, dp);
    }

    private int func(int n, Map<Integer, Integer> dp){
        if(n == 1){
            return 0;
        }
        if(n == Integer.MAX_VALUE){
            return 32;
        }
        if(dp.containsKey(n)){
            return dp.get(n);
        }
        if(n % 2 == 0){
            int ans = 1 + func(n / 2, dp);
            dp.put(n, ans);
        }
        else{
            int ans = 1 + Math.min(func(n - 1, dp), func(n + 1, dp));
            dp.put(n, ans);
        }
        return dp.get(n);
    }
}
