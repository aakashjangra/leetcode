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
    static class DisjointSet{
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        public DisjointSet(int n){
            for(int i = 0; i<=n; i++){
                rank.add(0);
                parent.add(i);
            }
        }
        public int findUPar(int node){
            if(node == parent.get(node)){
                return node;
            }
            int par = findUPar(parent.get(node));
            parent.set(node, par);
            return par;
        }
        public void unionByRank(int u, int v){
            int ulp_u = findUPar(u);
            int ulp_v = findUPar(v);
            if(ulp_u == ulp_v) return;
            if(rank.get(ulp_u) == rank.get(ulp_v)){
                parent.set(ulp_u, ulp_v);
                rank.set(ulp_v, rank.get(ulp_v) + 1);
            } else if(rank.get(ulp_u) < rank.get(ulp_v)){
                parent.set(ulp_u, ulp_v);
            } else if(rank.get(ulp_v) < rank.get(ulp_u)){
                parent.set(ulp_v, ulp_u);
            }
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        DisjointSet ds = new DisjointSet(V);
        
        for(int i = 0; i<V; i++){
            for(int j = 0; j<V; j++){
                if(adj.get(i).get(j) == 1){
                    //edge
                    ds.unionByRank(i, j);
                }
            }
        }
        
        int provinces = 0;
        for(int i = 0; i<V; i++){
            if(i == ds.parent.get(i)){
                provinces++;
            }
        } 
        
        return provinces;
    }
};