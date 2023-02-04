//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            out.println(ans);
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int findMaxSum(int arr[], int n) {
        int[] dp = new int[n];
        
        for(int i = 0; i<n; i++){
            int sum = arr[i];
            
            int pp = i-2 >= 0? dp[i-2]: 0;
            int ppp = i-3 >= 0? dp[i-3]: 0;
            
            dp[i] = sum + Math.max(pp, ppp);
            dp[i] = Math.max(dp[i], i-1 >= 0? dp[i-1]: 0);
        }
        
        return dp[n-1];
    }
}