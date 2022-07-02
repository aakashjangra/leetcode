class Solution {
    public int countQuadruplets(int[] nums) {
        int l = nums.length;
        int count = 0;
        for(int a = 0; a < l; a++){
            for(int b = a+1; b < l; b++){
                for(int c = b+1; c < l; c++){
                    for(int d = c+1; d < l; d++){
                        if(nums[a] + nums[b] + nums[c] == nums[d]){
                            ++count;
                        }                        
                    }
                }
            }
        }
        
        return count;
    }
}