class Solution {
    public int minCost(String colors, int[] neededTime) {
        char arr[] = colors.toCharArray();
        int n = neededTime.length;
        int ans = 0;
        Data data = new Data(arr[0], 0);

        for(int i = 1; i < n; i++){
            if(data.c == arr[i]){
                if(neededTime[data.ind] <= neededTime[i]){
                    ans += neededTime[data.ind];
                    data = new Data(arr[i], i);
                }
                else{
                    ans += neededTime[i];
                    continue;
                }
            }
            data = new Data(arr[i], i);
        }

        return ans;
    }
}

class Data{
    char c = ' ';
    int ind = 0;

    public Data(char c, int ind){
        this.c = c;
        this.ind = ind;
    }
}
