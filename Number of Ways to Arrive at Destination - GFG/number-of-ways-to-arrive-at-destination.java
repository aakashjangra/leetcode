//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
// Position this line where user code will be pasted.

class GFG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                adj.add(temp);
            }

            Solution obj = new Solution();
            System.out.println(obj.countPaths(n, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static class Pair{
        int node;
        long time;
        Pair(int n, long t){
            this.node = n;
            this.time = t;
        }
    }
    static int countPaths(int n, List<List<Integer>> roads) {
        // 0 to n-1 we have to travel
        int mod = (int)(1e9 + 7);
        List<List<Pair>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++) adjList.add(new ArrayList<>());
        for(List<Integer> road: roads){
            //bidirectional road
            int u = road.get(0), v = road.get(1), time = road.get(2);
            adjList.get(u).add(new Pair(v, time));
            adjList.get(v).add(new Pair(u, time));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b) -> a.time < b.time? -1: 1);
        // no. of ways to get to ith node in shortest time
        int[] ways = new int[n];
        ways[0] = 1;
        long[] timeArr = new long[n];
        Arrays.fill(timeArr, Integer.MAX_VALUE);
        timeArr[0] = 0;
        
        //source = 0, destination = n-1
        int dest = n-1;
        pq.add(new Pair(0, 0));
        
        int smallestTime = Integer.MAX_VALUE;
        
        while(!pq.isEmpty()){
            Pair cur = pq.poll();
            // System.out.println("time-> "+cur.time);
            for(Pair adj: adjList.get(cur.node)){
                long newTime = cur.time + adj.time;
                
                if(newTime == timeArr[adj.node]){
                    //add ways and not replace them
                    ways[adj.node] = ((ways[cur.node] % mod)+ ways[adj.node]) % mod;
                } else if(newTime < timeArr[adj.node]){
                    pq.add(new Pair(adj.node, newTime));
                    //newTime is smaller than prev.
                    ways[adj.node] = ways[cur.node];
                    timeArr[adj.node] = newTime;
                }
            }
        }
        
        return ways[dest];
    }
}
