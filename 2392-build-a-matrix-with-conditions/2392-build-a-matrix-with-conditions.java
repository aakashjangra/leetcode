class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> order1 = GenerateTopologicalSort(rowConditions, k);
        List<Integer> order2 = GenerateTopologicalSort(colConditions, k);
        if(order1.size() < k || order2.size() < k)  return new int[0][0];
        Map<Integer, Integer> m = new HashMap<>();
        for(int i = 0; i<k; i++)    m.put(order2.get(i), i);
        int[][] ans = new int[k][k];
        for(int i = 0; i<k; i++){
            ans[i][m.get(order1.get(i))] = order1.get(i);
        }
        
        return ans;
    }
    
    private List<Integer> GenerateTopologicalSort(int[][] arr, int k){
        int[] deg = new int[k+1];
        List<Integer> order = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<=k; i++){
            graph.add(new ArrayList<>());
        }
        Queue<Integer> q = new LinkedList<>();
        for(int[] edge: arr){
            graph.get(edge[0]).add(edge[1]);
            deg[edge[1]]++;
        }
        for(int i = 1; i<=k; i++)   
            if(deg[i] == 0)
                q.add(i);
        while(q.size() > 0){
            int v = q.poll();
            order.add(v);
            for(int adj: graph.get(v)){
                deg[adj]--;
                if(deg[adj] == 0)
                    q.add(adj);
            }
        }
        
        return order;
    }
}