class Solution {
    
    private int recHelper(int index, int transNo, int[] prices, int n, int k, int[][] dp){
        if(index == n || transNo == 2*k)  return 0;   
    
        //buy
        if(transNo % 2 == 0){
            if(dp[index][transNo] == -1){
                dp[index][transNo] = Math.max(-prices[index] + recHelper(index+1, transNo+1, prices, n, k, dp), 0 + recHelper(index+1, transNo, prices, n, k, dp));
            }
            
            return dp[index][transNo];
        }
        
        //sell
        if(dp[index][transNo] == -1){
            dp[index][transNo] = Math.max(prices[index] + recHelper(index+1, transNo+1, prices, n, k, dp), 0 + recHelper(index+1, transNo, prices, n, k, dp));
        }
        
        return dp[index][transNo];
    }
    
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        
        int[][] dp = new int[n+1][2*k+1];
        
        for(int i = 0; i <= n; i++){
            Arrays.fill(dp[i], -1);
        }
        
//         for(int i = 0; i <= n; i++){
//             for(int j = 0; j<=2*k; j++){
//                 if(i == n || j == 2*k)
//                     dp[i][j] = 0;
//             }
//         }
        
        return recHelper(0, 0, prices, n, k, dp);
    }
    
}