class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int l = nums.length;
        for(int i = 0; i<l; i++){
            if(hm.containsKey(target - nums[i])){
                return new int[]{hm.get(target - nums[i]), i};   
            } else {
                hm.put(nums[i], i);
            }
            
        }
        
        return new int[]{-1, -1};
    }
}