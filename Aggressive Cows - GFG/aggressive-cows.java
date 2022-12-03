//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static boolean possibleDist(int dist, int[] stalls, int n, int k){
        int cows = 1;
        int prev = stalls[0];
        
        for(int i = 1; i<n; i++){
            if(stalls[i] - prev >= dist){
                cows++;
                prev = stalls[i];
            }
        }
        return cows >= k;
    }
    public static int solve(int n, int k, int[] stalls) {
        
        //sorting stalls in asc. order
        Arrays.sort(stalls);
        
        int maxDistance = stalls[n-1] - stalls[0];
        
        int ans = -1;
        
        //binary search for maximum minimum distance from 1 to maxDistance
        int s = 1;
        int e = maxDistance;
        
        while(s <= e){
            int mid = e + (s - e)/2;
            
            if(possibleDist(mid, stalls, n, k)){
                s = mid + 1;
                ans = mid;
            } else {
                e = mid - 1;
            }
        }
        
        return ans;
    }
}