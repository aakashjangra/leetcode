class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int a:  nums){
            ans ^= a;
        }
        
        return ans;
    }
}