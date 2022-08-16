class Solution {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a,b) -> ((b[0]*b[0])+(b[1]*b[1])) - ((a[0]*a[0])+(a[1]*a[1])));
        for(int[] coordinates: points){
            maxHeap.add(coordinates);
            if(maxHeap.size() > k)
                maxHeap.poll();
        }
        
        int[][] ans = new int[k][2]; 
        int idx = 0;
        while(maxHeap.size() > 0){
            ans[idx++] = maxHeap.poll();
        }
        
        return ans;
    }
}