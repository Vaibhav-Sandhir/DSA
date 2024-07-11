class Solution {
public int candy(int[] ratings) {
        int sum = 0;
        int n = ratings.length;
        int[] left_comparisons = new int[n];
        int[] right_comparisons = new int[n];
        Arrays.fill(left_comparisons, 1);
        Arrays.fill(right_comparisons, 1);

        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i -1])
                left_comparisons[i] = left_comparisons[i - 1] + 1;
        }

        for(int i = n -2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1])
                right_comparisons[i] = right_comparisons[i + 1] + 1;
        }

        for(int i = 0; i < n; i++){
            sum += Math.max(left_comparisons[i], right_comparisons[i]);
        }

        return sum;
    }
}
