//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static class Custom{
        int node;
        int distance;
        public Custom(int n, int d){
            this.node = n;
            this.distance = d;
        }
    }
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        List<List<int[]>> adjList = new ArrayList<>();
        for(int i = 0; i<n+1 ;i++) adjList.add(new ArrayList<>());
        for(int[] edge: edges){
            int u = edge[0], v = edge[1], w = edge[2];
            adjList.get(u).add(new int[]{v, w});
            adjList.get(v).add(new int[]{u, w});
        }
        
        PriorityQueue<Custom> pq = new PriorityQueue<>((a,b) -> a.distance != b.distance? a.distance - b.distance: a.node - b.node);
        int[] dist = new int[n+1];
        int[] parent = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        //shortest path from 1 -> n
        pq.add(new Custom(1, 0));
        dist[1] = 0;
        parent[1] = 1;
        
        while(!pq.isEmpty()){
            int size = pq.size();
            while(size-- > 0){
                Custom cur = pq.poll();
                for(int[] adjArr: adjList.get(cur.node)){
                    int adj = adjArr[0], d = adjArr[1];
                    if(cur.distance + d < dist[adj]){
                        pq.add(new Custom(adj, cur.distance + d));
                        dist[adj] = cur.distance + d;
                        parent[adj] = cur.node;
                    }
                }
            }
        }
        
        List<Integer> ansPath = new ArrayList<>();
        
        if(dist[n] == Integer.MAX_VALUE)
            ansPath.add(-1); // if no shortest path found, we return this
        else {
            int node = n;
            ansPath.add(node);
            while(node != parent[node]){
                node = parent[node];
                ansPath.add(node);
            }
        }
        
        Collections.reverse(ansPath);
        
        return ansPath;
    }
}