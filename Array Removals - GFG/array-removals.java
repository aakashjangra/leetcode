//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().removals(arr, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int removals(int[] arr, int n, int k) {
        // code here
        Arrays.sort(arr);
        int r = n-1;
        int l = 0;
        int minElementsRemoved = Integer.MAX_VALUE;
        
        for(int i = 0; i<n; i++){
            int elementsRemoved = 0;
            for(int j = n-1; j>=i; j--){
                // System.out.println(arr[j]-arr[i]+" "+k);
                if(arr[j] - arr[i] <= k){
                    
                    minElementsRemoved = Math.min(n-j-1+i, minElementsRemoved);
                }
                
            }
        }
        
        return minElementsRemoved;
    }
}