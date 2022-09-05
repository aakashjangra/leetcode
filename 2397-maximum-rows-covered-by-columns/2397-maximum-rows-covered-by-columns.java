class Solution {
    private int maxR = 0;
    
    private int countRows(int[][] mat, Set<Integer> selected){
        int r = mat.length;
        int c = mat[0].length;
        int covered = r;
        
        for(int i = 0; i<r; i++){
            boolean nSafe = false;
            for(int j = 0; j<c; j++){
                if(!selected.contains(j) && mat[i][j] == 1)
                    nSafe = true;
            }
            if(nSafe)
                covered--;
        }
        
        return covered;
    }
        
    private void choices(int cur, int[][] mat, int cols, Set<Integer> selected){
        if(selected.size() > cols)
            return;
        
        if(selected.size() == cols){
            maxR = Math.max(maxR, countRows(mat, selected));
            return;
        }
        
        for(int i = cur; i<mat[0].length; i++){
            selected.add(i);
            
            choices(i+1, mat, cols, selected);
            
            selected.remove(i);
        }
    }
    
    public int maximumRows(int[][] mat, int cols) {
        int r = mat.length;
        int c = mat[0].length;
        
        if(cols == c)   return r;
        
        maxR = 0;
        Set<Integer> selected = new HashSet<>(); 
        
        choices(0, mat, cols, selected);
        
        return maxR;
    }
    
}