class Solution {

    public boolean isValidSudoku(char[][] board) {
        
        Set set = new HashSet();
        
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                char c = board[i][j];
                if(c != '.'){
                    if(!set.add("row"+c+i) ||
                       !set.add("col"+c+j) ||
                       !set.add("submatrix"+c+i/3+' '+j/3))
                        return false;
                }
            }
        }
        
        return true;
    }
}