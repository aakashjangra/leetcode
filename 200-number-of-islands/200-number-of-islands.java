class Solution {
    private void dfs(int i, int j, int[][] vis, char[][] grid){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || vis[i][j] == 1 || grid[i][j] == '0')
            return;
        vis[i][j] = 1;
        dfs(i-1, j, vis, grid);
        dfs(i+1, j, vis, grid);
        dfs(i, j-1, vis, grid);
        dfs(i, j+1, vis, grid);

    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        int ans = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(vis[i][j] == 0 && grid[i][j] == '1'){
                    dfs(i, j, vis, grid);
                    ans++;
                }
            }
        }
        
        return ans;
    }
}