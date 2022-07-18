class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int minr = 0, maxr = n-1, minc = 0, maxc = m-1;
        
        while(minr <= maxr && minc <= maxc){
              //top row, columns will change
            for(int col = minc; col <= maxc; col++){
                ans.add(matrix[minr][col]);
            }
            
            //right column
            for(int row = minr+1; row <= maxr; row++){
                ans.add(matrix[row][maxc]);
            }
            
            if(minr != maxr){
                //bottom row
            for(int col = maxc-1; col >= minc; col--){
                ans.add(matrix[maxr][col]);
            }
            }
            
            if(minc != maxc){
            
                //left column
                for(int row = maxr-1; row > minr; row--){
                    ans.add(matrix[row][minc]);
                }
            
            }
                
            minr++;
            maxr--;
            minc++;
            maxc--;
            
        }
        
        return ans;
    }
}