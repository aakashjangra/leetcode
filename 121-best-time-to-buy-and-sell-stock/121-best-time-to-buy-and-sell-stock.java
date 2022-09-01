class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int mini_cost = prices[0];
        int mProfit = 0;
        for(int i = 1; i < n; i++){
            mProfit =  Math.max(prices[i] - mini_cost, mProfit);
            mini_cost = Math.min(prices[i], mini_cost);
        }
        
        return mProfit;
    }
}