class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        //making array which will have efficiency and speed together
        int[][] players = new int[n][2];
        for(int i = 0; i<n; i++){
            players[i][0] = efficiency[i];
            players[i][1] = speed[i];
        }
        
        //sorting by freq. in descending order
        Arrays.sort(players, (a,b)-> b[0] - a[0]);
        
        //a heap to store values
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();//minHeap by default
        
        long totalSpeed = 0;
        long ans = 0;
        for(int i = 0; i<n; i++){
            if(minHeap.size() == k){
                totalSpeed -= minHeap.poll();
            }
            minHeap.add(players[i][1]);
            totalSpeed += players[i][1];
            
            ans = Math.max(ans, (totalSpeed*players[i][0]));
        }
        
        return (int)(ans % 1000000007);
    }
}