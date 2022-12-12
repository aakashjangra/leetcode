//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    private int time;
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        time = 0;
        Set<Integer> visited = new HashSet<>();
        ArrayList<Integer> points = new ArrayList<>();
        
        Map<Integer, Integer> visitedTime = new HashMap<>();
        Map<Integer, Integer> lowTime = new HashMap<>();
        Map<Integer, Integer> parent = new HashMap<>();
        
        int start = 0;
        parent.put(start, null);
        
        dfs(visited, points, start, visitedTime, lowTime, parent, adj);
        
        if(points.size() == 0) {
            points.add(-1);
        }
        Collections.sort(points);
        return points;
    }
    
    private void dfs(Set<Integer> visited, ArrayList<Integer> points, int vertex, Map<Integer, Integer> visitedTime,
                     Map<Integer, Integer> lowTime, Map<Integer, Integer> parent, ArrayList<ArrayList<Integer>> graph){
        visited.add(vertex);
        visitedTime.put(vertex, time);
        lowTime.put(vertex, time);
        time++;
        int childCount = 0;
        boolean isArticulationPoint = false;
        for(int adj: graph.get(vertex)){
            if(parent.get(vertex) != null && adj == parent.get(vertex)) continue;
            
            if(!visited.contains(adj)){
                parent.put(adj, vertex);
                childCount++;
                dfs(visited, points, adj, visitedTime, lowTime, parent, graph);
                
                if(visitedTime.get(vertex) <= lowTime.get(adj)){
                    isArticulationPoint = true;
                } else {
                    lowTime.put(vertex, Math.min(lowTime.get(vertex), lowTime.get(adj)));
                }
            } else {
                lowTime.put(vertex, Math.min(lowTime.get(vertex), visitedTime.get(adj)));
            }
        }
        
        if((parent.get(vertex) == null && childCount >= 2) || (parent.get(vertex) != null && isArticulationPoint)){
            points.add(vertex);
        }
                         
    }
}