/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void makeListOfNodes(TreeNode root, List l1){
        if(root != null){
            if(root.left == null && root.right == null){
                l1.add(root.val);
            }
            makeListOfNodes(root.left, l1);
            makeListOfNodes(root.right, l1);
        }
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        List<Integer> l1 = new ArrayList();
        List<Integer> l2 = new ArrayList();
        
        makeListOfNodes(root1, l1);
        makeListOfNodes(root2, l2);
        
        if(l1.size() != l2.size()){
            return false;
        }
        
        for(int i = 0; i<l1.size(); i++){
            if(l1.get(i) != l2.get(i)){
                return false;
            }
        }
        
        return true;
        
    }
}