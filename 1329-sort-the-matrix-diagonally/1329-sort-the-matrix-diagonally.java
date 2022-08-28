class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int n = mat.length; 
        int m = mat[0].length;
        for(int j = m-2; j>=0; j--){
            int r = 0;
            int c = j;
            List<Integer> list = new ArrayList<>();
            while(r < n && c < m){
                list.add(mat[r][c]);
                r++;
                c++;
            }
            Collections.sort(list);
            r = 0;
            c = j;
            int idx = 0;
            while(r < n && c < m){
                mat[r][c] = list.get(idx);
                idx++;
                r++;
                c++;
            }
        }
        
        for(int i = 1; i<n-1; i++){
            int r = i;
            int c = 0;
            List<Integer> list = new ArrayList<>();
            while(r < n && c < m){
                list.add(mat[r][c]);
                r++;
                c++;
            }
            Collections.sort(list);
            r = i;
            c = 0;
            int idx = 0;
            while(r < n && c < m){
                mat[r][c] = list.get(idx);
                idx++;
                r++;
                c++;
            }
        }
        
        return mat;
    }
}