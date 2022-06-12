class Solution {
    
    public boolean searchMatrix(int[][] matrix, int target) {
        
        for(int i = 0; i < matrix.length; i++){
            // for(int j = 0; j < matrix[i].length; j++){
            //     if(target == matrix[i][j]){
            //         return true;
            //     }
            // }
                int start = 0;
                int end = matrix[i].length-1;
        
            while(end >= start){
                int mid = (start+end)/2; 
                if(target > matrix[i][mid]){
                    start = mid + 1;
                } else if(target < matrix[i][mid]){
                    end = mid - 1;
                } else{
                    return true;
                }
            }
        
        
    }
        return false;
    
    }
}