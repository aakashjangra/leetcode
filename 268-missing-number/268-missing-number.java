class Solution {
    public int missingNumber(int[] nums) {
        int  n = nums.length;
        int sumTotal = (n*(n+1))/2;
        int sum = 0;
        for(int el: nums){
            sum += el;
        }
        
        return sumTotal - sum;
    }
}