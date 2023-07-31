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

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    Set<List<String>> set;
    int[][] vis;
    int m;
    int n;
    int countDistinctIslands(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        vis = new int[m][n];
        set = new HashSet<>(); // to store patterns
        
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                //if this cell is Land and Not Visited, visit it -> run dfs on it
                if(grid[i][j] == 1 && vis[i][j] == 0){
                    List<String> path = new ArrayList<>();
                    dfs(i, j, path, grid, i, j);
                    set.add(path);
                }
            }
        }
        
        return set.size();
    }
    
    void dfs(int i, int j, List<String> path, int[][] grid, int rbase, int cbase){
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0 || vis[i][j] == 1){
            return;
        }
        
        String cur = " ("+Integer.toString(i - rbase)+","+Integer.toString(j - cbase)+") ";
        path.add(cur);
        vis[i][j] = 1;
        
        //dfs in 4 dirs
        dfs(i, j+1, path, grid, rbase, cbase);
        dfs(i, j-1, path, grid, rbase, cbase);
        dfs(i+1, j, path, grid, rbase, cbase);
        dfs(i-1, j, path, grid, rbase, cbase);
    }
}

