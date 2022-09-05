/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)    return ans;
        
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i<n; i++){
                Node cur = q.poll();
                level.add(cur.val);
                List<Node> children = cur.children;
                for(int idx = 0; idx<children.size(); idx++){
                    q.offer(children.get(idx));
                }
            }
            ans.add(level);
        }
        
        return ans;
    }
}