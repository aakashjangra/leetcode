class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        HashMap<Character, Integer> freq = new HashMap<>();
        for(char c: tasks){
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); 
        maxHeap.addAll(freq.values());
        
        int time = 0;
        while(maxHeap.size() > 0){
            ArrayList<Integer> add_back = new ArrayList<>();
            for(int i = 0;i<=n; i++){
    
                if(maxHeap.size() > 0){
                    int count = maxHeap.poll();
                    count--;
                    if(count > 0){
                        add_back.add(count);
                    }    
                }   
                 
                    time++;
                
                    if(maxHeap.size() == 0 && add_back.size() == 0)
                        break;
            }
               
            maxHeap.addAll(add_back);            
        }
        
        return time;
    }
}