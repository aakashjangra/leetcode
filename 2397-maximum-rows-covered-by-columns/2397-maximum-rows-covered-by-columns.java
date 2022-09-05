class Solution {
    private int maxR = 0;
    
    private int countRows(int[][] mat, Set<Integer> unSelected){
        int r = mat.length;
        int c = mat[0].length;
        int covered = r;
        
        // System.out.println(unSelected);
        for(int i = 0; i<r; i++){
            for(int j: unSelected){
                // System.out.print(j+" ");
                if(mat[i][j] == 1){
                    // System.out.println("Y");
                    covered--;
                    break;
                }
                // System.out.println();
            }
        }
        
        return covered;
    }
        
    private void choices(int cur, int[][] mat, int cols, Set<Integer> unSelected){
        if(mat[0].length-unSelected.size() > cols)
            return;
        
        if(mat[0].length-unSelected.size() == cols){
            maxR = Math.max(maxR, countRows(mat, unSelected));
        }
        
        for(int i = cur; i<mat[0].length; i++){
            unSelected.remove(i);
            
            choices(i+1, mat, cols, unSelected);
            
            unSelected.add(i);
        }
    }
    
    public int maximumRows(int[][] mat, int cols) {
        int r = mat.length;
        int c = mat[0].length;
        
        if(cols == c)   return r;
        
        maxR = 0;
        Set<Integer> unSelected = new HashSet<>(); 
        for(int i = 0; i<c; i++)    unSelected.add(i);
        
        choices(0, mat, cols, unSelected);
        
        return maxR;
    }
    
}