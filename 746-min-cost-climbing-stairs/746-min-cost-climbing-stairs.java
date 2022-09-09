class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[n-1] = cost[n-1];
        dp[n-2] = cost[n-2];
        
        for(int index = n-3; index >= 0; index--){
            dp[index] = cost[index] + Math.min(dp[index+1], dp[index+2]);
        }
        
        return Math.min(dp[0], dp[1]);
    }
}