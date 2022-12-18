//{ Driver Code Starts
// Initial Template for Java

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
            System.out.println(ob.maxGcd(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long maxGcd(int N){
        return Math.max(solve(N), solve(N-1));
    }
    long gcd(long a, long b){
        if(a == 0) return b;
        
        return gcd(b%a, a);
    }
    long solve(int N) {
        long ans = N;
        int count = 3;
        for(int i = N-1; i>1; i--){
            
            if(gcd(ans, i) == 1l){
                ans *= i;
                count--;
            }
            
            if(count == 0) break;
        }
        
        return ans;
    }
}