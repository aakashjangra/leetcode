class Solution {
    public int minCostToMoveChips(int[] position) {
        
        int zeros = 0;
        int ones = 0;
        
        for(int a: position){
            if(a % 2 == 0)
                zeros++;
             else 
                ones++;
        }     
        
        return Math.min(zeros, ones);
    }
}