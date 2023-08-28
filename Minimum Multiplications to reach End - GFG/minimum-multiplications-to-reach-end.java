//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java



// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        if(start == end) return 0;
        
        int mod = 100000;
        int[] dist = new int[mod];
        Arrays.fill(dist, Integer.MAX_VALUE);
        //int[] -> {node, steps}
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});
        dist[start] = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] curPair = q.poll();
                int cur = curPair[0], steps = curPair[1];
                
                for(int a: arr){
                    int num = (cur * a) % mod;
                    if(steps+1 < dist[num]){
                        if(num == end) return steps+1;
                        
                        q.add(new int[]{num, steps+1}); 
                        dist[num] = steps+1; 
                    } 
                }
            }
        }
        
        return -1;
    }
}