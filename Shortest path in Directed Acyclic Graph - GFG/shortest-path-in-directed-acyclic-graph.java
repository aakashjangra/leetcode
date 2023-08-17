//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
	    //making adjList
	    List<List<int []>> adjList = new ArrayList<>();
	    for(int i = 0; i<N; i++) adjList.add(new ArrayList<>());
	    
	    for(int[] edge: edges){
	        int u = edge[0], v = edge[1], d = edge[2];
	        //u -> v, distance = d
	        adjList.get(u).add(new int[]{v, d});
	    }
		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		//[] -> {val, dist}
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{0, 0});
		dist[0] = 0;
		
		while(q.size() > 0){
		    int size = q.size();
		    while(size-- > 0){
		        int[] cur = q.poll();
		        int val = cur[0], distance = cur[1];
		        
		        for(int[] adj: adjList.get(val)){
		            int v = adj[0], d = adj[1];
		            int newD = distance + d;
		            if(newD < dist[v]){
		                dist[v] = newD;
		                q.add(new int[]{v, newD});
		            }
		        }
		    }
		}
		
		//storing -1 in places we couldn't reach
		for(int i = 0; i<N; i++){
		    if(dist[i] == Integer.MAX_VALUE){
		        dist[i] = -1;
		    }
		}
		
		return dist;
	}
}