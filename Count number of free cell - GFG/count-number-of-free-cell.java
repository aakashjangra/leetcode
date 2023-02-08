//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine().trim());
        while(T>0)
        {
            String s[]=in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int[][] a = new int[k][2];
            for(int i=0; i<k; i++){
                s=in.readLine().trim().split(" ");
                a[i][0] = Integer.parseInt(s[0]);
                a[i][1] = Integer.parseInt(s[1]);
            }
            Solution g = new Solution();
            long[] res = g.countZero(n,k,a);
            
            for(int i=0; i<res.length; i++){
                out.print(res[i]+" ");
            }
            out.println();
            T--;
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    long[] countZero(int N, int K, int[][] arr){
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        long total = (long)N*(long)N;
        long[] ans = new long[K];
        
        int i = 0;
        for(int[] coord: arr){
            int r = coord[0], c = coord[1];
            rows.add(r);
            cols.add(c);
            
            int rSize = rows.size();
            int cSize = cols.size();
            //calculate zeros
            long zeros = total - (((rSize * N) + (cSize * N)) - (rSize * cSize));
            ans[i++] = zeros;
        }
        
        return ans;
    }
}