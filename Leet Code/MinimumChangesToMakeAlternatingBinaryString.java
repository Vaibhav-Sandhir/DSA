class Solution {
    public int minOperations(String s) {
       int count1 = 0;
       int count2 = 0;
       int n = s.length();

       for(int i = 0; i < n; i++){
           char c = s.charAt(i);
           if(c != '0' && i % 2 == 0){
               count1++;
           }
           if(c != '1' && i % 2 != 0){
               count1++;
           }
           if(c != '0' && i % 2 != 0){
               count2++;
           }
           if(c != '1' && i % 2 == 0){
               count2++;
           }
       }

       return Math.min(count1, count2); 
    }
}
