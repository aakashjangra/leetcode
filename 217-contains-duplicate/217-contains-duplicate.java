class Solution {
    public boolean containsDuplicate(int[] nums) {
        int l = nums.length;
       Set<Integer> ans = new HashSet<>();
        
        for(int i=0; i<l; i++){
            if(ans.contains(nums[i]))
                return true;
            
            ans.add(nums[i]);
        }
        
        return false;
    }
}