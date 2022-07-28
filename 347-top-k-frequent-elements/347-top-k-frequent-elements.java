class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int index = -1;
        for(int num: nums){
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }
        
        int []arr = new int[nums.length];
        int i = 0;
        for(Map.Entry<Integer, Integer> entry: freq.entrySet()){
            arr[i++] = entry.getValue();
        }
        
        Arrays.sort(arr);
        int val = arr[arr.length-k];
        
        int []ans = new int[k];
        i = 0;
        for(Map.Entry<Integer, Integer> entry: freq.entrySet()){
            if(entry.getValue() >= val){
                ans[i++] = entry.getKey(); 
            }
        }
        
        return ans;
    }
}