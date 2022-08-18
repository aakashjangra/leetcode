class Solution {
    public int minSetSize(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int a: arr){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        for(int freq: map.values()){
            maxHeap.add(freq);
        }
       
        int count = 0;
        int elems = 0;
        while(maxHeap.size() > 0){
            elems += maxHeap.poll();
            count++;
            if(elems >= n/2)
                return count;
        }
        
        return count;
    }
}