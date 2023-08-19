//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i<n; i++) adjList.add(new ArrayList<>());
        for(int[] edge: edges){
            int u = edge[0], v = edge[1];
            //undirected graph -> bidirectional graph
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        
        Queue<int[]> q = new LinkedList<>();
        //int[] -> {node, dist to reach this node}
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[src] = 0;
        q.add(new int[]{src, 0});
        
        while(q.size() > 0){
            int size = q.size();
            while(size-- > 0){
                int[] arr = q.poll();
                int cur = arr[0], d = arr[1];
                
                for(int adj: adjList.get(cur)){
                    if(d + 1 < dist[adj]){
                        dist[adj] = d+1;
                        q.add(new int[]{adj, d+1});
                    }
                }
            }
        }
        
        for(int i = 0; i<n; i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1;
            }
        }
        
        return dist;
    }
}