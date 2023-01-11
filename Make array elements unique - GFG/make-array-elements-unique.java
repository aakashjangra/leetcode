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

            
            int i = 0;
            int N = Integer.parseInt(br.readLine().trim());
        
            int arr[] = new int[(int)(N)];
            
            String inputLine2[] = br.readLine().trim().split(" ");
            for ( i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(inputLine2[i]);
            }
        
            Solution ob = new Solution();
            System.out.println(ob.minIncrements(arr,N));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public long minIncrements(int[] arr, int N) {
        long ans = 0L;
        int prev = 0;
        //sort array in asc. order
        Arrays.sort(arr);
        
        int n = arr.length;
        for(int i = 0; i<n; i++){
            int val = arr[i];
            if(prev >= val){
                //making val == val+1, ex - 2 --> 2 + 1 = 3
                ans += prev+1 - val;
                arr[i] = prev+1;
            } 
            
            prev = arr[i];
        }
        
        return ans;
    }
}