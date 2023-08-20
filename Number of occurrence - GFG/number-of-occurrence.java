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
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        int left = bs(arr, x, false);
        int right = bs(arr, x, true);
        
        return right - left + 1;
    }
    int bs(int[] arr, int x, boolean right){
        int s = 0, e = arr.length - 1;
        
        while(s <= e){
            int mid = (s + e)/2;
            if(arr[mid] > x){
                e = mid - 1;
            } else if(arr[mid] < x){
                s = mid + 1;
            } else {
                //if same
                if(right){
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }
        
        return right? s-1: e+1;
    }
}