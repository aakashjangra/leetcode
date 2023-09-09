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
            int m = sc.nextInt();
            int[][] edge = new int[m][2];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            int ans = obj.Solve(n, edge);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    class DisjointSet {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        public DisjointSet(int n) {
            for(int i = 0;i<=n;i++) {
                rank.add(0); 
                parent.add(i); 
            }
        }
    
        public int findUPar(int node) {
            if(node == parent.get(node)) {
                return node; 
            }
            int ulp = findUPar(parent.get(node)); 
            parent.set(node, ulp); 
            return parent.get(node); 
        }
    
        public void unionByRank(int u, int v) {
            int ulp_u = findUPar(u); 
            int ulp_v = findUPar(v); 
            if(ulp_u == ulp_v) return; 
            if(rank.get(ulp_u) < rank.get(ulp_v)) {
                parent.set(ulp_u, ulp_v); 
            }
            else if(rank.get(ulp_v) < rank.get(ulp_u)) {
                parent.set(ulp_v, ulp_u); 
            }
            else {
                parent.set(ulp_v, ulp_u); 
                int rankU = rank.get(ulp_u); 
                rank.set(ulp_u, rankU + 1); 
            }
        }
    }

    public int Solve(int n, int[][] edges) {
        int extraEdges = 0; //we will add redundant edges here
        int edgesUsed = 0;
        DisjointSet ds = new DisjointSet(n);
        
        for(int[] edge: edges){
            int u = edge[0], v = edge[1];
            if(ds.findUPar(u) == ds.findUPar(v)){
                extraEdges++;
            } else {
                ds.unionByRank(u, v);
                edgesUsed++;
            }
        }
        
        int reqEdges = (n-1) - edgesUsed;
        if(reqEdges > extraEdges) return -1;
        
        return reqEdges;
    }
}