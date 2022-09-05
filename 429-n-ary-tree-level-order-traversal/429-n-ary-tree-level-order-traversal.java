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
    private void helper(Node root, int level, List<List<Integer>> ansList){
        if(root == null)    return;
        
        if(level >= ansList.size())     ansList.add(new ArrayList<>());
        
        ansList.get(level).add(root.val);
        
        for(int i = 0; i<root.children.size(); i++){
            helper(root.children.get(i), level+1, ansList);
        }
    }
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, 0, ans);
        return ans;
    }
}