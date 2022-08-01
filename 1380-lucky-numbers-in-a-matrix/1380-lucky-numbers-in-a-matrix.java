class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int m = matrix.length;
        int n = matrix[0].length;
        
        for(int i = 0; i<m; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < n; j++){
                min = Math.min(matrix[i][j], min);
            }
            set.add(min);
        }
        
        for(int j = 0; j < n; j++){
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < m; i++){
                max = Math.max(matrix[i][j], max);
            }
            if(set.contains(max)){
                ans.add(max);
            }
        }
        
        return ans;
    }
}