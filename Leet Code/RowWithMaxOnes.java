class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int answers[] = new int[m];
        int max = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 1)
                    answers[i] += 1;
            }
            max = Math.max(max, answers[i]);
        }

        for(int i = 0; i < m; i++){
            if(max == answers[i])
                return new int[]{i, max};
        }
        return null;
    }
}
