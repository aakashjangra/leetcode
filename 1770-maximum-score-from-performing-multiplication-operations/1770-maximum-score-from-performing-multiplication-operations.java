class Solution {
//     private int rec(int op, int left, int m, int[] nums, int[] mult, Integer[][] dp){
//         if(op == m){
//             return 0;
//         }
        
//         if(dp[op][left] != null){
//             return dp[op][left];
//         }

//         //if we choose left 
//         int l = mult[op]*nums[left] + rec(op+1, left+1, m, nums, mult, dp); 
        
//         //if we choose right
//         int right = nums.length-1+left-op; 
//         int r = mult[op]*nums[right] + rec(op+1, left, m, nums, mult, dp);  
        
//         dp[op][left] = Math.max(l, r);
        
//         return dp[op][left];
        
//     }
    public int maximumScore(int[] nums, int[] mult) {
        int n = nums.length;        // n>=m 
        int m = mult.length;
        
        // dp[op][left]

        //initialization state of dp //all elements will have 0 by default
        int[][] dp = new int[m+1][m+1];

        for(int op = m-1; op>=0; op--){
            for(int left = op; left>=0; left--){
                // if we choose left 
                int l = mult[op]*nums[left] + dp[op+1][left+1]; 

                //if we choose right
                int right = nums.length-1+left-op; 
                int r = mult[op]*nums[right] + dp[op+1][left];  


                dp[op][left] = Math.max(l, r);
            }
        }
        
        return dp[0][0];
    }
}