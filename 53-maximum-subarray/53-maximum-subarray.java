class Solution {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int curr = 0;
        for(int a: nums){
            curr += a;
            if(curr > ans){
                ans = curr;
            }
            if(curr < 0){
                curr = 0;
            }
            
        }
        
        return ans;
    }
}