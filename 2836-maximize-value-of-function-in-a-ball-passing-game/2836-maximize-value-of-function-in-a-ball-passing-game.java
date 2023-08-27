class Solution {
    public long getMaxFunctionValue(List<Integer> receiver, long k) {
        int m = 35, n = receiver.size();
        //dp[i][j] means from j, move 2^i steps, (end point, profit)
        long [][][]dp = new long[m][n][2];
        for(int j=0; j<n; j++)    dp[0][j][0] = dp[0][j][1] = (long)receiver.get(j);
        for(int i=1; i<m; i++){
            for(int j=0; j<n; j++){
                int x = (int)dp[i-1][j][0];
                dp[i][j] = new long[]{dp[i-1][x][0], dp[i-1][j][1] + dp[i-1][x][1]};
            }
        }
        
        long res = 0;
        for(int i = 0; i<n; i++){
            long r = i;
            int now = i;
            for(int j = 0; j<m; j++){
                if(((1l << j) & k) == 0) continue;
                r += dp[j][now][1];
                now = (int)dp[j][now][0];
            }
            res = Math.max(r, res);
        }
        
        return res;
    }
}