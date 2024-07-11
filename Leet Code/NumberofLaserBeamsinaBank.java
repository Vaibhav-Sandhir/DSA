class Solution {
    public int numberOfBeams(String[] bank) {
        int m = bank.length;
        int n = bank[0].length();
        int sum[] = new int[m];
        int lasers = 0;
        for(int j = 0; j < bank.length; j++){
            int ans = 0;
            for(char c : bank[j].toCharArray()){
                if(c == '1'){
                    ans++;
                }
            }
            sum[j] = ans; 
        }
        
        int left = 0;
        int right = 1;

        while(right < m){
            if(sum[right] != 0){
                lasers = lasers + (sum[left] * sum[right]);
                left = right;
            }
            right++;
        }

        return lasers;
    }
}
