class Solution {
    private int rec(int n, int curSteps, int[] dp){
        if(curSteps == n)
            return 1;
        if(curSteps > n)
            return 0;
        
        if(dp[curSteps+1] == 0){
            dp[curSteps+1] = rec(n, curSteps+1, dp);
        }
        if(dp[curSteps+2] == 0){
            dp[curSteps+2] = rec(n, curSteps+2, dp);
        }
        return dp[curSteps+1] + dp[curSteps+2];
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+2];
        
        return rec(n, 0, dp);
    }
}