class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = nums.length;
        int answer = nums[0];
        
        for(int a: nums){
            hm.put(a, hm.getOrDefault(a, 0)+1);
        }
        
        for(Map.Entry<Integer, Integer> entry: hm.entrySet()){
            if(entry.getValue() > n/2){
                answer = entry.getKey();
            }
        }
        
        return answer;
    }
}