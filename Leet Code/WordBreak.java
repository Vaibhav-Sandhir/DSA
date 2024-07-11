class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean dp[] = new boolean[n + 1];
        dp[n] = true;

        for(int i = n - 1; i >= 0; i--){
            for(String sub : wordDict){
                if(sub.length() > n - i)
                    continue;
                System.out.println(i);    
                String str = s.substring(i, i + sub.length());
                System.out.println(sub + "  " + str);
                if(sub.equals(str)){
                    System.out.println("Hello");
                    dp[i] = dp[i + sub.length()];
                }
            }
        }
        return dp[0];
    }
}
