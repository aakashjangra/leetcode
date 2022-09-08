class Solution {
    private int helper(int cur, int end, int taken, int k, int[][] dp){
        if(taken == k){
            if(cur == end)
                return 1;
            else 
                return 0;
        }
        if(taken > k)
            return 0;
        
        if(dp[cur-1][taken+1] == -1){
            dp[cur-1][taken+1] = helper(cur-1, end, taken+1, k, dp) % 1000000007;
        }
        
        if(dp[cur+1][taken+1] == -1){
            dp[cur+1][taken+1] = helper(cur+1, end, taken+1, k, dp) % 1000000007;
        }
        
        return dp[cur-1][taken+1] + dp[cur+1][taken+1];
    }
    public int numberOfWays(int startPos, int endPos, int k) {
        
        // if(startPos == endPos)
        //     return 0;

        int[][] dp = new int[2000+startPos+2][2000+k+2];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        
        return helper(1000+startPos, 1000+endPos, 0, k, dp) % 1000000007;
    }
}