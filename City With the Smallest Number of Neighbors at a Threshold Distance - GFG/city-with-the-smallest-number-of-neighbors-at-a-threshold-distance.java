//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] adj = new int[m][3];

            for (int i = 0; i < m; i++) {

                for (int j = 0; j < 3; j++) {
                    adj[i][j] = sc.nextInt();
                }
            }

            int dist = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.findCity(n, m, adj, dist);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    class Pair{
        int node;
        int d;
        Pair(int n, int dist){
            this.node = n;
            this.d = dist;
        }
    }
    int findCity(int n, int m, int[][] edges,int distanceThreshold)
    {
        List<List<Pair>> adjList = new ArrayList<>(); //sc -> V^2
        for(int i = 0; i<n; i++) adjList.add(new ArrayList<>());
        for(int[] edge: edges){
            //bidirectional
            adjList.get(edge[0]).add(new Pair(edge[1], edge[2]));
            adjList.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.d - b.d); //sc -> V
        int city = 0;
        int cities = Integer.MAX_VALUE;
        //tc = V * (E*logV + V) => V^2 + EVlogV
        for(int i = 0; i<n; i++){
            //find shortest dist from every node
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            pq.add(new Pair(i, 0));
            dist[i] = 0;
            
            //tc - E * logV
            while(!pq.isEmpty()){
                Pair curP = pq.poll();
                int cur = curP.node, d = curP.d;
                for(Pair adjP: adjList.get(cur)){
                    int newD = d + adjP.d;
                    if(newD <= distanceThreshold && newD < dist[adjP.node]){
                        pq.add(new Pair(adjP.node, newD));
                        dist[adjP.node] = newD;
                    }
                }
            }
            
                //calculating city with minCities reachable in threshold
            //count cities reachable
            int citiesReachable = 0;
            for(int j = 0; j<n; j++){
                if(i != j && dist[j] != Integer.MAX_VALUE){
                    citiesReachable++;
                }
            }
            if(citiesReachable <= cities){
                city = i;
                cities = citiesReachable;
            }
        }  

        return city;
    }
}
