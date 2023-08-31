//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static class Custom{
        int node;
        int wt;
        int parent;
        Custom(int n, int w){
            this.node = n;
            this.wt = w;
        }
        Custom(int n, int w, int p){
            this.node = n;
            this.wt = w;
            this.parent = p;
        }
    }
	static int spanningTree(int V, int E, int edges[][]){
	    List<List<Custom>> adjList = new ArrayList<>();
	    for(int i = 0; i<V; i++) adjList.add(new ArrayList<>());
	    for(int[] edge: edges){
	        adjList.get(edge[0]).add(new Custom(edge[1], edge[2]));
	        adjList.get(edge[1]).add(new Custom(edge[0], edge[2]));
	    }
	    int[] vis = new int[V];
	    PriorityQueue<Custom> pq = new PriorityQueue<>((a,b) -> a.wt - b.wt); //minHeap, least weight on top
	    
	    pq.add(new Custom(0, 0, -1));
	    int weightMSP = 0;
	    
	    while(!pq.isEmpty()){
	        Custom cur = pq.poll();
	        if(vis[cur.node] == 1) continue;
	        
	        vis[cur.node] = 1;
	        weightMSP += cur.wt;
	        
	        for(Custom adj: adjList.get(cur.node)){
	            if(vis[adj.node] == 0){
	                pq.add(new Custom(adj.node, adj.wt, cur.node));
	            }
	        }
	    }
	    
	    return weightMSP;
	}
}