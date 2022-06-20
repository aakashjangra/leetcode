class Solution {
    public int search(int[] nums, int target) {
        int s = 0, e = nums.length-1;
        while(s <= e){
            int m = (s+e)/2;
            if(target < nums[m]){
                e = m - 1;
            } else if(target > nums[m]){
                s = m + 1;
            } else {
                return m;
            }
        }
        
        return -1;
    }
}