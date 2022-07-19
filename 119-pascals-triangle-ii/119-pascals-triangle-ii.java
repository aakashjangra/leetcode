class Solution {
    public List<Integer> getRow(int rowIndex) {
  
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<>();
  
        
        for(int i = 0; i<=rowIndex; i++){
            List<Integer> row = new ArrayList<>();
            
            for(int j = 0; j<=i; j++){
                
                if(j == 0 || i == j){
                    row.add(1);
                } else {
                    int num = ans.get(i-1).get(j-1) + ans.get(i-1).get(j);  
                    row.add(num);
                }
                
            }
            
            if(i == rowIndex){
                return row;             
            }
            
            ans.add(row);
            
        }
        
        return temp;

    }
}