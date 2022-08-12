class Solution {
    class Pair{
        int diff;
        int val;
        Pair(int d, int v){
            diff = d;
            val = v;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(
            new Comparator<Pair>(){
                public int compare(Pair a, Pair b){
                    //if both diff are same then compare on the basis of their values
                    if(a.diff == b.diff)
                        return b.val - a.val;
                    return b.diff - a.diff;
                }
            }
        );
        
        // 2 values needs to be passed in Heap and should be sorted based on first value
        
        for(int a: arr){
            
            maxHeap.add(new Pair(Math.abs(a - x), a));
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        
        while(maxHeap.size() > 0){
            Pair curr = maxHeap.poll();
            ans.add(curr.val);
        }
        
        Collections.sort(ans);
        return ans;
    }
}