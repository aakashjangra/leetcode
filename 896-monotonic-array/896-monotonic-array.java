class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean flag = false;
        boolean first = false;
        
        for(int i = 1; i<nums.length; i++){
            if(nums[i-1] < nums[i]){
                if(first && flag)
                    return false;
                flag = false;
                first = true;
            } else if(nums[i-1] > nums[i]){
                if(first && !flag)
                    return false;
                flag = true;
                first = true;
            }
        }
        
        return true;
    }
}