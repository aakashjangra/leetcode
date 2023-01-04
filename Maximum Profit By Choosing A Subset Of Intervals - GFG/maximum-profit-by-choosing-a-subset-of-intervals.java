//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m) {
        for (var a : m) {
            for (int e : a) System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int[][] intervals = IntMatrix.input(br, n, 3);

            Solution obj = new Solution();
            int res = obj.maximum_profit(n, intervals);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maximum_profit(int n, int[][] intervals) {
// code here
        Arrays.sort(intervals,(a,b) -> (a[0]-b[0]));
        int[] memo = new int[n];
        for(int i=n-1;i>=0;i--) {
            // helper -> to searh for >=
            int idx = helper(intervals,intervals[i][1]);
            if(idx>=memo.length) {
                memo[i]=intervals[i][2];
            } else {
                memo[i] = intervals[i][2]+memo[idx];
            }
            if(i!=n-1) memo[i] = Math.max(memo[i],memo[i+1]);
        }
        return memo[0];
    }
    
    public static int helper(int[][] a,int val) {
        int lo=0,hi=a.length-1,ans=a.length;
        while(lo<=hi) {
            int mid = lo+(hi-lo)/2;
            if(a[mid][0]<val) {
                lo=mid+1;
            } else {
                hi=mid-1;
                ans = Math.min(ans,mid);
            }
        }
        return ans;
    }
}
