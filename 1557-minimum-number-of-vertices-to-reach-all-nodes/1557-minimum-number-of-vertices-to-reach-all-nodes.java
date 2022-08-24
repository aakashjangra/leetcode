class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i<n; i++){
            set.add(i);
        }
        for(List<Integer> edge: edges){
            int dst = edge.get(1);
            set.remove(dst);
        }
        
        List<Integer> ans = new ArrayList<>(set);
        return ans;
    }
}