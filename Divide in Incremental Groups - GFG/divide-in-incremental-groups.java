//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int N = Integer.parseInt(br.readLine().trim());
            int K = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            System.out.println(ob.countWaystoDivide(N, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    Integer[][][] dp;
    public int countWaystoDivide(int N, int K) {
        dp = new Integer[N+1][K+1][101];
        int count = helper(N, K, 1, N);
        
        return count;
    }
    public int helper(int N, int K, int last, int sum){
        //base case
        if(K == 0) {
            if(sum == 0) return 1;
            else return 0;
        }
        
        if(sum < 0) return 0;
        
        if(dp[sum][K][last] != null) return dp[sum][K][last];
        
        int ways = 0;
        for(int i = last; i<=N; i++){
            //recursive calls
            ways += helper(N, K-1, i, sum-i);
        }
        
        return dp[sum][K][last] = ways;
    }
}