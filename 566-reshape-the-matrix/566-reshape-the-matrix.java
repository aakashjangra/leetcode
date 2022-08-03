class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int n = mat.length;
        int m = mat[0].length;
        if(n*m != r*c)
            return mat;
        
        int [][]ans = new int[r][c];
        int row = 0;
        int col = 0;
        for(int []arr: mat){
            for(int num: arr){
                if(col == c){
                    col = 0;
                    row++;
                }
                ans[row][col] = num;
                col++;
            }
        }
        
        return ans;
    }
}