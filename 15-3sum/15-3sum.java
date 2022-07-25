class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        Arrays.sort(nums);
        
        for(int i = 0; i<nums.length; i++){
            while(i > 0 && i < nums.length && nums[i] == nums[i-1]){
                i++;
            }
            int j = i+1;
            int k = nums.length-1;
            while(j < k){
                
                int sum = nums[i]+nums[j]+nums[k];
                if(sum == 0){
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);

                    ans.add(triplet);
                    j++;
                    k--;
                    while(j < nums.length-1 && nums[j] == nums[j-1]){
                        j++;
                    }
                    while(k > 0 && nums[k] == nums[k+1]){
                        k--;
                    }
                    
                } else if(sum < 0){
                    j++;
                } else {
                    k--;
                }
            }
        }
        
        return ans;
    }
}