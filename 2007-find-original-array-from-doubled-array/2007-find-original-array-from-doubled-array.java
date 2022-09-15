class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        
        // array is empty or array size is odd 
        if((n&1) == 1)
            return new int[]{};
        
        //sorting to access from smallest to largest elements 
        Arrays.sort(changed);
        
        //list to store original array numbers
        List<Integer> list = new ArrayList<>();
        
        //priority queue to access smallest element whose double needs to be found
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        //iterating through given array
        for(int a: changed){
            //if minHeap is empty or the current element is not double of min element available, add current element to heap
            if(minHeap.isEmpty() || minHeap.peek()*2 != a){
                minHeap.add(a);
                
            }   // else don't. as this element is double of element in minHeap
            else {
                list.add(minHeap.poll());
            }
        }
        
        if(list.size()*2 != n)
            return new int[]{};
        
        int[] original = list.stream().mapToInt(Integer::intValue).toArray();

        return original;
    }
}