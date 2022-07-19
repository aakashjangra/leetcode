class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        for(int i = 0; i<numRows; i++){
            List<Integer> row = new ArrayList<>();
            
            for(int j = 0; j<=i; j++){
                
                if(j == 0 || i == j){
                    row.add(1);
                } else {
                    int num = ans.get(i-1).get(j-1) + ans.get(i-1).get(j);  
                    row.add(num);
                }
                
            }
            
            ans.add(row);
            
        }
        
        return ans;
    }
}