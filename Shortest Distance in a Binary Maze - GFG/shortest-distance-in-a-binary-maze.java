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
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] dest) {
        int n = grid.length, m = grid[0].length;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        q.add(source);
        vis[source[0]][source[1]] = 1;
        
        int distance = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] cur = q.poll();
                int i = cur[0], j = cur[1];
                
                if(i == dest[0] && j == dest[1]) return distance;
                
                for(int[] dir: dirs){
                    int r = i+dir[0], c = j+dir[1];
                    if(r < 0 || c < 0 || r >= n || c >= m) {
                        //invalid indices, continue to next one
                        continue;
                    }
                    if(vis[r][c] == 0 && grid[r][c] == 1){
                        q.add(new int[]{r,c});
                        vis[r][c] = 1;
                    }
                }
            }
            
            distance++;
        }
        
        return -1;
    }
}
