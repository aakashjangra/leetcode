class Solution {
    public int longestSubarray(int[] nums) {
        int ans = 0;
        int curr = 0;
        int prev = 0;
        int n = nums.length;
        for(int i = 0; i<n; i++){
            if(nums[i] == 1){
                curr++;
            } else {
                ans = Math.max(ans, curr + prev);
                prev = curr;
                curr = 0;
            }
            ans = Math.max(ans, curr + prev);
        }

        if(ans == n)
            ans--;
        
        return ans;
    }
}