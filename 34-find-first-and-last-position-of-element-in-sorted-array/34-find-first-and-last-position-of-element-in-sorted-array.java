class Solution {
    public int binarySearch(int []nums, int target, boolean left){
        int start = 0;
        int end = nums.length-1;
        int index = -1;
        while(start <= end){
            int mid = end + (start - end)/2;
            
            if(nums[mid] == target){
                index = mid;
                if(left){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if(nums[mid] < target){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return index;
    }
    public int[] searchRange(int[] nums, int target) {
        return new int[]{binarySearch(nums, target, true), binarySearch(nums, target, false)};
    }
}