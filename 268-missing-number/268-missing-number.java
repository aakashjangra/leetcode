class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0;
        int n = nums.length;
        while(n > 0){
            xor ^= n;
            n--;
        }
        for(int num: nums)
            xor ^= num;
        
        return xor;
    }
}