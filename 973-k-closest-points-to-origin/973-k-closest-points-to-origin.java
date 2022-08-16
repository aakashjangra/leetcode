class Solution {
    private class myVar{
        int dist;
        int x; 
        int y;
        public myVar(int d, int x, int y){
            this.dist = d;
            this.x = x;
            this.y = y;
        }
    }
    private int distFromOrigin(int x1, int y1){ 
        //x2 and y2 == 0, as we are finding distance from origin
        return (int)(Math.pow(x1, 2) + Math.pow(y1, 2));
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<myVar> maxHeap = new PriorityQueue<myVar>((a,b) -> b.dist - a.dist);
        for(int[] coordinates: points){
            int x = coordinates[0];
            int y = coordinates[1];
            maxHeap.add(new myVar(distFromOrigin(x, y), x, y));
            if(maxHeap.size() > k)
                maxHeap.poll();
        }
        
        int[][] ans = new int[k][2]; 
        int idx = 0;
        while(maxHeap.size() > 0){
            ans[idx][0] = maxHeap.peek().x;
            ans[idx][1] = maxHeap.peek().y;
            maxHeap.poll();
            idx++;
        }
        
        return ans;
    }
}