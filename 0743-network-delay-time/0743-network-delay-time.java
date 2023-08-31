class Solution {
    class Pair{
        int node;
        int time;
        Pair(int n, int t){
            this.node = n;
            this.time = t;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] time = new int[n+1];
        Arrays.fill(time, Integer.MAX_VALUE);
        List<List<Pair>> adjList = new ArrayList<>();
        for(int i = 0; i<=n; i++) adjList.add(new ArrayList<>());
        
        for(int[] arr: times){
            adjList.get(arr[0]).add(new Pair(arr[1], arr[2]));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.time - b.time); //minHeap
        
        pq.add(new Pair(k, 0));
        time[k] = 0;
        time[0] = 0; // 0 is not a node
        
        while(!pq.isEmpty()){
            Pair cur = pq.poll();
            
            for(Pair adj: adjList.get(cur.node)){
                int newTime = cur.time + adj.time;
                if(newTime < time[adj.node]){
                    time[adj.node] = newTime;
                    pq.add(new Pair(adj.node, newTime));
                }
            }
        }
        
        int maxTime = 0;
        for(int val: time){
            if(val == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(val, maxTime);
        }
        
        return maxTime;
    }
}