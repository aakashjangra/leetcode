class Solution {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a,b) -> b[0] - a[0]);
        for(int[] coordinates: points){
            int x = coordinates[0];
            int y = coordinates[1];
            maxHeap.add(new int[]{(x*x)+(y*y), x, y});
            if(maxHeap.size() > k)
                maxHeap.poll();
        }
        
        int[][] ans = new int[k][2]; 
        int idx = 0;
        while(maxHeap.size() > 0){
            ans[idx][0] = maxHeap.peek()[1];
            ans[idx][1] = maxHeap.peek()[2];
            maxHeap.poll();
            idx++;
        }
        
        return ans;
    }
}