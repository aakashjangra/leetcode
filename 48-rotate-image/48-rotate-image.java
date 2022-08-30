class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;  //n X n matrix
        //reversing rows
        for(int i = 0; i<n; i++){
            int l = 0;
            int r = n-1;
            while(l < r){
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
                l++;
                r--;
            }
        }
        //taking transpose of the matrix
        int wall = 1;
        //iterating in rows leaving last node
        for(int i = 0; i<n-1; i++){
            int l = 0; 
            int r = n-wall;
            //in every row going till l < index n - wall
            while(l < r){
                int temp = matrix[i][l];
                //col will be according to row and row will be according to col
                matrix[i][l] = matrix[n-l-1][n-i-1];
                matrix[n-l-1][n-i-1] = temp;
                l++;
            }
            //incrementing wall, so that limited cols gets transposed and not the elements after diagonal
            wall++;
        }
            
    }
}