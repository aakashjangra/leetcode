//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution
{
    int MOD = 1_000_000_007;
    long k;
    long countWays(int n,int K)
    {
        k = (long)K;
        long []dp = new long[n+3];
        dp[1] = k;
        dp[2] = add(k ,mul(k, k-1));
        
        for(int i = 3; i<=n; i++){
            dp[i] = add(mul(dp[i-1], k-1), mul(dp[i-2], k-1));
        }
        
        return dp[n]%MOD;
    }
    long mul(long a, long b){
        return ((a%MOD) * (b%MOD)) %MOD;
    }
    long add(long a, long b){
        return ((a%MOD) + (b%MOD)) %MOD;
    }
    long solve(int n){
        if(n == 1) return k;
        if(n == 2) return k + (k*(k-1));
        
        long diff = (solve(n-1)%MOD) * (k-1);
        long same = (solve(n-2)%MOD) * (k-1);
        
        return ((diff%MOD) + (same%MOD)) % MOD;
    }

}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main (String[] args) throws IOException{
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while(testcases-- > 0){
            //int n=Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] a2 = line.trim().split("\\s+");
            int n =Integer.parseInt(a2[0]);
            int k =Integer.parseInt(a2[1]);

            Solution ob=new Solution();
            //ArrayList<Long> ans=ob.smallestDifferenceTriplet(a,b,c,n);
            long ans=ob.countWays(n,k);
            System.out.println(ans);
        }
    }
}



// } Driver Code Ends