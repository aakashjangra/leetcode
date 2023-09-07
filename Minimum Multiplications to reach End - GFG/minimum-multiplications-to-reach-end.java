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

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        int[] steps = new int[(int)1e5];
        Arrays.fill(steps, Integer.MAX_VALUE);
        steps[start] = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        
        while(!q.isEmpty()){
            int cur = q.poll();
            if(cur == end) return steps[cur];
            
            int newSteps = steps[cur] + 1;
            for(int m: arr){
                int num = (cur * m) % (int)(1e5);
                if(newSteps < steps[num]){
                    steps[num] = newSteps;
                    q.add(num);
                }
            }
        }
        
        return -1;
    }
}
