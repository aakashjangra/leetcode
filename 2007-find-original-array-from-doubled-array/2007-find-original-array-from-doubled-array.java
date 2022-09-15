class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        int mid = n/2;
        
        // array is empty or array size is odd 
        if(n == 0 || (n&1) == 1)
            return new int[]{};
        
        Arrays.sort(changed);
        
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int a: changed){
            if(minHeap.isEmpty() || minHeap.peek()*2 != a){
                minHeap.add(a);
            } else {
                list.add(minHeap.poll());
                // System.out.println(a);
            }
        }
            // System.out.println(list);
        
        if(list.size()*2 != n)
            return new int[]{};
        
        int[] original = list.stream().mapToInt(Integer::intValue).toArray();

        return original;
    }
}