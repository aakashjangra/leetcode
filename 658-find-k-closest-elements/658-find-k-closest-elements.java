class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();     
        int len = arr.length;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] < b[0] || a[0] == b[0] && a[1] < b[1]? 1: -1);
        
        for(int num: arr){
            minHeap.add(new int[]{Math.abs(num-x), num});
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        
        
        while(!minHeap.isEmpty()){
            int[] diffAndVal = minHeap.poll();
            //taking only num
            
            ans.add(diffAndVal[1]);
        }
        
        Collections.sort(ans);
        
        return ans;
    }
}