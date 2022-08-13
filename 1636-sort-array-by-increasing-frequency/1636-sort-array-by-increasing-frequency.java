class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)-> a[0] != b[0]? a[0] - b[0]: b[1] - a[1]);
        
        for(int a: nums){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        
        for(int key: map.keySet()){
            maxHeap.add(new int[]{map.get(key), key});
        }
        
        int idx = 0;
        while(maxHeap.size() > 0){
            int freq = maxHeap.peek()[0];
            int val = maxHeap.peek()[1];
            
            while(freq-- > 0){
                nums[idx++] = val;            
            }
            
            maxHeap.poll();
        }
        
        return nums;
    }
}