//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends

class Solution {
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        List<Integer> safeNodes = new ArrayList<>();
        int[] vis = new int[V];
        int[] path = new int[V];
        int[] check = new int[V];
        
        for(int i = 0; i<V; i++){
            if(vis[i] == 0){
                //unvisited
                detectCycle(i, adj, vis, path, check);
            }
        }
        
        for(int i = 0; i<V; i++){
            if(check[i] == 1){
                //safeNode
                safeNodes.add(i);
            }
        }
        
        return safeNodes;
    }
    boolean detectCycle(int node, List<List<Integer>> adjacents, int[] vis, int[] path, int[] check){
        vis[node] = 1;
        path[node] = 1;
        
        for(int adj: adjacents.get(node)){
            if(vis[adj] == 0){
                //unvisited
                boolean isCycle = detectCycle(adj, adjacents, vis, path, check);
                
                if(isCycle){
                    //cycle found
                    return true;
                }
            } else if(path[adj] == 1){
                return true; //cycle
            }
        }
        
        check[node] = 1;
        path[node] = 0;
        return false;
    }
}
