//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int splitArray(int[] arr , int N, int K) {
        // code here
        int min = 0, max = 0;
        for(int a: arr){
            min = Math.max(min, a);
            max += a;
        }
        
        int ans = 0;
        // System.out.println("min & max: "+min+" "+max);
        int s = min, e = max;
        while(s <= e){
            int mid = e + ((s - e)/2);
            if(feasible(mid, arr, K)){
                ans = mid;
                // System.out.println("ans: "+ans);
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        
        return ans;
    }
    static boolean feasible(int target, int[] arr, int k){
        int sum = 0;
        
        for(int i = 0; i<arr.length; i++){
            int val = arr[i];
            if(val > target){
                //can't put this value in any subarray
                return false;
            }
            if(sum + val <= target){
                sum += val;
            } else {
                //we can't take this number in the current subarray, make new subarray
                sum = val;
                k--;
            }
        }
        
        //for the last subarray
        k--;
        
        return k >= 0;
    }
};