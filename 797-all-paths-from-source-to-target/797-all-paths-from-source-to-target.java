class Solution {
    private void helper(int el, int n, List<Integer> path, List<List<Integer>> ans, int[][] graph){
        if(path.get(path.size()-1) == n-1){
            ans.add(new ArrayList<Integer>(path));
            return;
        }
        for(int elem: graph[path.get(path.size() - 1)]){
            path.add(elem);
            helper(elem, n, path, ans, graph);
            path.remove(path.size() - 1);
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int n = graph.length;
    
        List<Integer> path = new ArrayList<>();
        path.add(0);
        helper(0, n, path, ans, graph);
        
        return ans;
    }
}