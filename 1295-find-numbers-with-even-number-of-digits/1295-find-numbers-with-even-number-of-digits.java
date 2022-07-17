class Solution {
    public int findNumbers(int[] nums) {
        
        int ans = 0;
        
        for(int a: nums){
            String s = Integer.toString(a);
            if(s.length()%2 == 0){
                ans++;
            }
        }
        
        return ans;
    }
}