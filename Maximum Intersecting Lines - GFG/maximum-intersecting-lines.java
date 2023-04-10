//{ Driver Code Starts
// Initial Template for Java
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

            int lines[][] = new int[(int)(N)][2];

            for (int j = 0; j < 2; j++) {
                String inputLine2[] = br.readLine().trim().split(" ");
                for (i = 0; i < N; i++) {
                    lines[i][j] = Integer.parseInt(inputLine2[i]);
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.maxIntersections(lines, N));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maxIntersections(int[][] lines, int n) {
        SortedMap<Integer, Integer> map = new TreeMap<>();
        for(int[] point: lines){
            int s = point[0], e = point[1];
            map.put(s, map.getOrDefault(s, 0) + 1);
            map.put(e+1, map.getOrDefault(e+1, 0) - 1);
        }
        
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for(int key: map.keySet()){
            sum += map.get(key);
            res = Math.max(sum, res);
        }
        
        return res;
    }
}
