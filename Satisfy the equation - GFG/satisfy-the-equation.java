//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] A = new int[N];
            
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            int[] ptr = ob.satisfyEqn(A,N);
            
            System.out.println(ptr[0] + " " + ptr[1] + " " + ptr[2] + " " + ptr[3]);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static boolean matches(int num, int a, int b, int c){
        
        if(num == a || num == b || num == c) return true;
        
        return false;
    }
    static int[] satisfyEqn(int[] arr, int n) {
        Map<Integer, int[]> map = new HashMap<>();
        int max = Integer.MAX_VALUE;
        int[] ans = {max, max, max, max};
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                int sum = arr[i] + arr[j];
                if(map.containsKey(sum)){
                    //ans
                    int[] pair = map.get(sum);
                    int a = pair[0], b = pair[1];
                    //if duplicate indices, exit
                    if(matches(a, b, i, j) || matches(b, a, i, j) || matches(i, a, b, j) || matches(j, i, a, b)) continue;
                    //putting answer indices in ans[] array if lexicographically smaller
                    if(a < ans[0] || ((a == ans[0] && b < ans[1]) || ((b == ans[1] && i < ans[2]) || (i == ans[2] && j < ans[3])))){
                        ans[0] = a;
                        ans[1] = b;
                        ans[2] = i;
                        ans[3] = j;
                    }
                    
                    //update 
                } else {
                    map.put(sum, new int[]{i, j});
                }
            }
        }
        
        if(ans[0] != max) return ans;
        //else no pairs satisfies the equation
        Arrays.fill(ans, -1);
        return ans;
    }
};