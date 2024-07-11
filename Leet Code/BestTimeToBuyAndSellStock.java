class Solution {
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        int profit = 0;
        int n = prices.length;
        int left_buy = 0;
        int right_sell = 1;

        while(right_sell < n){

            if(prices[left_buy] < prices[right_sell]){
                profit = prices[right_sell] - prices[left_buy];
                max_profit = Math.max(profit, max_profit);
            }
            else{
                left_buy = right_sell;
            }

            right_sell += 1;
        }

        return max_profit; 

    }
}
