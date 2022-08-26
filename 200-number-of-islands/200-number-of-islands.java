class Solution {
    private void bfs(int i, int j, char[][] grid){
        
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')   return ;
        
        grid[i][j] = '0';
        
        bfs(i-1, j, grid);
        bfs(i+1, j, grid);
        bfs(i, j-1, grid);
        bfs(i, j+1, grid);

    }
    public int numIslands(char[][] grid) {
        int count = 0;
        
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    bfs(i, j, grid);
                    count++;
                }
            }
        }
        
        return count;
    }
}