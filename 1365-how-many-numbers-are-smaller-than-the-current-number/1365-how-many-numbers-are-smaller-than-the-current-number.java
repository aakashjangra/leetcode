class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int l = nums.length;
        int[] ans = new int[nums.length];
       for(int i=0; i<l; i++){
           int count = 0;
           for(int j=0; j<l; j++){
               if(nums[j] < nums[i])
                   ++count;
           }
           ans[i] = count;
       }
        
        return ans;
    }
}