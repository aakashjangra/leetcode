class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] ans = new int[nums.length];
        
        for(int i = 0; i<nums.length; i++){
            for(int j = nums.length-1; j>index[i] ; j--){           
                    ans[j] = ans[j-1];     
            }
            ans[index[i]] = nums[i];
        }
            
        return ans;
    }
}