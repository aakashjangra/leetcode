class Solution {
    public int findNumbers(int[] nums) {
        
        int ans = 0;
        
        for(int a: nums){
            int nod = 0;
            while(a > 0){
                a /= 10;
                nod++;
            }
            
            if(nod % 2 == 0){
                ans++;
            }
        }
        
        return ans;
    }
}