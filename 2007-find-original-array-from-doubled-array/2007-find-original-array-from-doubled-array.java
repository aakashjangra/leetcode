class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        
        // array is empty or array size is odd 
        if((n&1) == 1)
            return new int[]{};
        
        //sorting to access from smallest to largest elements 
        Arrays.sort(changed);
        
        //list to store original array numbers
        int[] original = new int[n/2];
        
        //priority queue to access smallest element whose double needs to be found
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        int idx = 0;
        //iterating through given array
        for(int a: changed){
            //if minHeap is empty or the current element is not double of min element available, add current element to heap
            if(minHeap.isEmpty() || minHeap.peek()*2 != a){
                minHeap.add(a);       
            }   // else don't. as this element is double of element in minHeap
            else {
                original[idx++] = minHeap.poll();
            }
        }
        
        if(!minHeap.isEmpty())
            return new int[]{};
        
        return original;
    }
}