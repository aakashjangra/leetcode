class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> ar = new ArrayList<>();
        
        for(int i = 0; i<nums.length; i++){
            ar.add(1);
        }
        
        for(int i = 1; i<nums.length; i++){
            for(int j = 0; j<i; j++){
                if(nums[j] < nums[i]){
                   
                    ar.set(i,Math.max(ar.get(i),1+ar.get(j)));
                    
                }
            }
        }
            
        int max = ar.get(0);
        for(int i = 0; i<ar.size(); i++){
            max = Math.max(ar.get(i), max);
        }
            
        return max;
    }
}