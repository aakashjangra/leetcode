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
            int n = sc.nextInt();
            int k = sc.nextInt();

            int tmp = sc.nextInt();
            int[][] flights = new int[tmp][3];
            for (int i = 0; i < tmp; i++) {

                int u1 = sc.nextInt();
                int v1 = sc.nextInt();
                int w1 = sc.nextInt();
                flights[i][0] = u1;
                flights[i][1] = v1;
                flights[i][2] = w1;
            }

            Solution ob = new Solution();
            int ans = ob.minimumCost(flights, n, k);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int minimumCost(int[][] flights, int n, int k) {
        // Your code here
        int[] cost = new int[n+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[k] = 0;
        
        //int[] -> {node, cost}
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i<=n ;i++) graph.add(new ArrayList<>());
        
        for(int[] flight: flights){
            int u = flight[0];
            int v = flight[1];
            int cost1 = flight[2];
            graph.get(u).add(new int[]{v, cost1});
        }
        
        //minimum cost logic
        ArrayDeque<int[]> que = new ArrayDeque<>();
        que.add(new int[]{k, 0});
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            int u = cur[0];
            int cost1 = cur[1];
            
            for(int[] adj: graph.get(u)){
                int v = adj[0];
                int cost2 = adj[1];
                // System.out.printf("%d %d <= %d\n", cost1, cost2, cost[v]);
                if(cost1 + cost2 <= cost[v]){
                    cost[v] = cost1 + cost2;
                    que.add(new int[]{v, cost1 + cost2});
                }
            }
        }
        
        int maxMoneyForAnyCity = 0;
        //check min. money he should have, so that he can visit any city
        for(int i = 1; i<=n; i++){
            // System.out.printf("Cost of %d: %d\n", i, cost[i]);
            if(cost[i] == Integer.MAX_VALUE){
                return -1;
            }
            maxMoneyForAnyCity = Math.max(maxMoneyForAnyCity, cost[i]);
        }
        
        return maxMoneyForAnyCity;
    }
}
