class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int dp[][] = new int[triangle.size()][triangle.size()];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return getMinSum(triangle, 0, 0, dp);
    }

    public int getMinSum(List<List<Integer>> triangle, int row, int column, int dp[][]){
        if(row == triangle.size()){
            return 0;
        }    

        if(dp[row][column] != -1)
            return dp[row][column];

        dp[row][column] = Math.min(getMinSum(triangle, row + 1, column, dp), getMinSum(triangle, row + 1, column + 1, dp))  + triangle.get(row).get(column);
        return dp[row][column];
    }
}
