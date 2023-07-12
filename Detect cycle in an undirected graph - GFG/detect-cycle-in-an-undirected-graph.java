//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        
        for(int i = 0; i<V; i++){
            if(vis[i] == 1) continue;
            
            if(dfs(i, -1, adj, vis)) return true;
        }
        
        return false;
    }
    public boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adjacent, int[] vis){
        if(vis[node] == 1) return false;
        vis[node] = 1;
        
        for(int adj: adjacent.get(node)){
            if(vis[adj] == 0){
                //not visited
                if(dfs(adj, node, adjacent, vis)) return true;
            } else if(adj != parent){
                //if node is visited and parent and adj are same
                return true;
            }
        }
        
        return false;
    }
}