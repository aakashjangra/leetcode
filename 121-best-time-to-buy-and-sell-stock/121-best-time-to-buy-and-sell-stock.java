class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] maxAfterThis = new int[n];
        maxAfterThis[n-1] = 0;
        for(int i = n-2; i >= 0; i--){
            maxAfterThis[i] = Math.max(maxAfterThis[i+1], prices[i+1]);
        }
        int mProfit = 0;
        for(int i = 0; i<n; i++){
            mProfit = Math.max(mProfit, maxAfterThis[i] - prices[i]);
        }
        
        return mProfit;
    }
}