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
        Queue<int[]> bfs = new LinkedList<>();
        
        for(int i = 0; i<V; i++){
            if(vis[i] == 1) continue;
            bfs.add(new int[]{i, -1});
            vis[i] = 1;
            
            while(!bfs.isEmpty()){
                int n = bfs.size();
                while(n-- > 0){
                    int[] cur = bfs.poll();
                    int node = cur[0], parent = cur[1];
                    for(int adjacent: adj.get(node)){
                        if(vis[adjacent] == 0){ //not visited
                            bfs.add(new int[]{adjacent, node});
                            vis[adjacent] = 1;
                        } else if(parent != adjacent){
                            //if they form a cycle
                            return true;
                        }
                    }
                }
            }
        }
       
        
        return false;
    }
}