class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        int resultLength = 0;
        int left = 0;
        int right = 0;
        int n = s.length();

        for(int i = 0; i < n; i++){
            left = i;
            right = i;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
                if(right - left + 1 > resultLength){
                    result = s.substring(left, right + 1);
                    resultLength = result.length();
                }
                left--;
                right++;
            }  

            left = i;
            right = i + 1;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
                if(right - left + 1 > resultLength){
                    result = s.substring(left, right + 1);
                    resultLength = result.length();
                }
                left--;
                right++;
            }            
        }

        return result;  
    }
}
