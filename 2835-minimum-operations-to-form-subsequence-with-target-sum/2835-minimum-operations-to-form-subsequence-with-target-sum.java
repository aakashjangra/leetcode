class Solution {
    public int minOperations(List<Integer> nums, int target) {
        int n = nums.size();
        long total = 0;
        for(int a: nums) total += a;
        if(total < target) return -1; //we can't make it
        Collections.sort(nums);
        int oper = 0;
        
        while(target > 0){
            int a = nums.remove(nums.size() - 1);
            if(total - a >= target){
                total -= a;
            } else if(a <= target){
                total -= a;
                target -= a;
            } else {
                nums.add(a/2);
                nums.add(a/2);
                oper++;
            }
        }
        
        return oper;
    }
}