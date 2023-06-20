//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adjMatrix, int V) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<V; i++) adj.add(new ArrayList<>());
        
        for(int i = 0; i<V; i++){
            for(int j = 0; j<V; j++){
                if(adjMatrix.get(i).get(j) == 1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        
        int[] vis = new int[V];
        Queue<Integer> q = new LinkedList<>();
        int provinces = 0;
        for(int i = 0; i < V; i++){
            if(vis[i] == 1){
                //if visited, skip
                continue;
            }
            provinces++;
            q.add(i);
            vis[i] = 1;
            while(!q.isEmpty()){
                int cur = q.poll();
                for(int adjacents: adj.get(cur)){
                    if(vis[adjacents] == 0){
                        q.add(adjacents);
                        vis[adjacents] = 1;
                    }
                }
            }
        }
        
        //-1 to remove 0th node
        return provinces;
    }
};