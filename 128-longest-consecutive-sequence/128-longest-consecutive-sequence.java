class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        
        System.out.println(set);
        
        int ans = 0;
        int count = 0;
        for(int num: nums){
            if(!set.contains(num-1)){
                count = 1;
                while(set.contains(++num)){
                    count++;
                }
            }
            ans = Math.max(ans, count);
        }
        
        return ans;
    }
}