class Solution {
    public void sortColors(int[] nums) {
        int i = 0;
        int l = 0; 
        int r = nums.length-1;
        while(i <= r){
            if(nums[i] == 0){
                nums[i] = nums[l];
                nums[l] = 0;
                l++;
                i++;
            }else if(nums[i] == 2){
                nums[i] = nums[r];
                nums[r] = 2;
                r--;
            }else {
                i++;
            }
        }
    }
}