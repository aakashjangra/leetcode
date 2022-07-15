class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int max = 0;
        int curr = 1;
        for(int i = 0; i<n; i++){
            
            if(nums[i] == 0){
                curr = 1;
            } else {
               curr = curr*nums[i];
               max = Math.max(max, curr);
            }
            
        }
        
        curr = 1;
        for(int i = n-1; i>=0; i--){
            if(nums[i] == 0){
                curr = 1;
            } else {
                 curr = curr*nums[i];
                 max = Math.max(max, curr);
            }
            
        }
        
        return max;
    }
}