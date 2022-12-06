//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    public int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
    
        int[][] res = new int[n][m];
        ArrayDeque<int[]> que = new ArrayDeque<>();
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 1){
                    res[i][j] = 0;
                    que.offer(new int[]{i, j});
                } else {
                    res[i][j] = -1;
                }
            }
        }
     
        while(!que.isEmpty()){
            int[] arr = que.poll();
            int x = arr[0];
            int y = arr[1];
            
            for(int[] dir: dirs){
                int i_ = x + dir[0];
                int j_ = y + dir[1];
                
                if(i_ < 0 || j_ < 0 || i_ >= grid.length || j_ >= grid[0].length || res[i_][j_] != -1) continue;
                
                res[i_][j_] = res[x][y] + 1;
                que.offer(new int[]{i_, j_});
            }
            
        }
        
        // for(int i = 0; i<n; i++){
        //     for(int j = 0; j<m; j++){
        //         if(grid[i][j] == 1){
        //             res[i][j] = 0;
        //         } else {
        //             int[][] vis = new int[n][m];
        //             res[i][j] = bfs(i, j, grid, vis);
        //         }
        //     }
        // }
        
        return res;
    }
}