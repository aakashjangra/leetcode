//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.fillingBucket(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int countWays(int current, int target, int[] dp){
        int mod = 100_000_000;
        if(current > target) return 0;
        if(current == target) return 1;
        
        if(dp[current] != -1) return dp[current];
        
        //1. we added 1 litre  
        if(dp[current+1] == -1) dp[current+1] = countWays(current+1, target, dp) % mod;
        //2. we added 2 litre
        if(dp[current+2] == -1) dp[current+2] = countWays(current+2, target, dp) % mod;
        //sum of both ways - 
        return  dp[current] = (dp[current+1] + dp[current+2]) % mod;
    }
    static int fillingBucket(int N) {

        // code here
        if(N == 0) return 0;
        
        int[] dp = new int[N+2];
        Arrays.fill(dp, -1);
        
        return countWays(0, N, dp);
    }
};