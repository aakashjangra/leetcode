class Solution {
    
    private boolean validRows(char[][] board){
        int n = 9;
        for(int i = 0; i<n; i++){
            HashSet<Character> set = new HashSet<>();
            for(int j = 0; j<n; j++){
                if(board[i][j] != '.' && set.contains(board[i][j]))
                   return false;
                set.add(board[i][j]);
            }
        }
        
        return true;
    }

    private boolean validCols(char[][] board){
        int n = 9;
        for(int j = 0; j<n; j++){
            HashSet<Character> set = new HashSet<>();
            for(int i = 0; i<n; i++){
                if(board[i][j] != '.' && set.contains(board[i][j]))
                   return false;
                set.add(board[i][j]);
            }
        }
        
        return true;
    }

    private boolean validSubs(char[][] board){
        int n = 9;
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        HashSet<Character> set3 = new HashSet<>();
        for(int i = 0; i<n; i++){
            if(i == 3 || i == 6){
                set1 = new HashSet<>();
                set2 = new HashSet<>();
                set3 = new HashSet<>();
            }
            for(int j = 0; j<3; j++){
                if(board[i][j] != '.' && set1.contains(board[i][j]))
                    return false;
                set1.add(board[i][j]);
            }
            for(int j = 3; j<6; j++){
                if(board[i][j] != '.' && set2.contains(board[i][j]))
                    return false;
                set2.add(board[i][j]);
            }
            for(int j = 6; j<n; j++){
                if(board[i][j] != '.' && set3.contains(board[i][j]))
                    return false;
                set3.add(board[i][j]);
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        
        return validRows(board) && validCols(board) && validSubs(board);
        
    }
}