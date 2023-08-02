//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        int[] path = new int[V];
        
        for(int i = 0; i<V; i++){
            if(vis[i] == 1){
                //if visited, continue
                continue;
            }
            if(dfs(i, adj, vis, path)){
                //cycle exists, return true
                return true;
            }
        }
        
        return false;
    }
    
    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] path){
        vis[node] = 1;
        path[node] = 1;
        
        for(int adjacent: adj.get(node)){
            if(vis[adjacent] == 0){
                //not visited
                if(dfs(adjacent, adj, vis, path)){
                    //cycle exists, return true
                    return true;
                }
                
                path[adjacent] = 0; //mark unvisited on this path, as we are backtracking on that path
            } else if(path[adjacent] == 1){
                // if visited again on same path, then cycle exists
                return true;
            }
        }
        
        path[node] = 0; //mark unvisited on this path, as we are backtracking on that path
        
        return false;
    }
}