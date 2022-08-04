class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean violation = false;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1]){
                if(nums[i+1] < max){
                    nums[i+1] = nums[i];
                } else {
                    nums[i] = nums[i+1];
                }
                if(violation)
                    return false;
                violation = true;
            }
            max = Math.max(nums[i], max);
        }
        
        return true;
    }
}