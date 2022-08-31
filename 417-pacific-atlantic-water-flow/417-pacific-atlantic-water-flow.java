class Solution {
    private boolean pacific(int i, int j, int[][] heights, int prev, boolean[][] visi){
        
        if(i < 0 || j < 0)
            return true;
        
        if(i >= heights.length || j >= heights[i].length)
            return false;
        
        if(visi[i][j] || heights[i][j] > prev)
            return false;
        
        visi[i][j] = true;
        
        boolean up = pacific(i-1, j, heights, heights[i][j], visi);
        boolean left = pacific(i, j-1, heights, heights[i][j], visi);
        boolean down = pacific(i+1, j, heights, heights[i][j], visi);
        boolean right = pacific(i, j+1, heights, heights[i][j], visi);
        
        return up || left || down || right;
    }
    private boolean atlantic(int i, int j, int[][] heights, int prev, boolean[][] visi){
        if(i < 0 || j < 0)
            return false;
        
        if(i >= heights.length || j >= heights[i].length)
            return true; 
        
        if(visi[i][j] || heights[i][j] > prev)
            return false;
        
        visi[i][j] = true;
        
        boolean up = atlantic(i-1, j, heights, heights[i][j], visi);
        boolean left = atlantic(i, j-1, heights, heights[i][j], visi);
        boolean down = atlantic(i+1, j, heights, heights[i][j], visi);
        boolean right = atlantic(i, j+1, heights, heights[i][j], visi);
        
        return up || left || down || right;
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = heights.length;
        int m = heights[0].length;
        
        for(int i = 0; i<heights.length; i++){
            for(int j = 0; j<heights[i].length; j++){
                boolean[][] visi1 = new boolean[n][m];
                boolean[][] visi2 = new boolean[n][m];
                if(pacific(i, j, heights, heights[i][j], visi1) && atlantic(i, j, heights, heights[i][j], visi2)){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                }
            }
        }
        
        return ans;
    }
}