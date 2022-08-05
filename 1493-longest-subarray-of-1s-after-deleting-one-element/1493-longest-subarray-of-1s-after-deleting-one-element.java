class Solution {
    public int longestSubarray(int[] nums) {
        boolean firstZero = true;
        int ans = 0;
        int curr = 0;
        int lastZero = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 1){
                curr++;
            } else {
                if(firstZero)
                    firstZero = false;
                else {
                    curr = i - lastZero - 1;
                }
                lastZero = i;
            }
            ans = Math.max(ans, curr);
        }
        
        if(ans == nums.length)
            ans--;
        
        return ans;
    }
}