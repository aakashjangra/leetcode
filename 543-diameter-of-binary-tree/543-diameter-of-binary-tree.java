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
    public Pair<Integer, Integer> measure(TreeNode root){
        if(root != null){
            if(root.left == null && root.right == null){
                return new Pair(1, 1);
            }
            Pair<Integer, Integer> l = measure(root.left);
            Pair<Integer, Integer> r = measure(root.right);
            int depth = Math.max(l.getKey(), r.getKey())+1;
            return new Pair(depth, Math.max(Math.max(l.getValue(), r.getValue()), l.getKey() + r.getKey() + 1));
        }
        
        return new Pair(0, 0);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        Pair<Integer, Integer> p = measure(root);
        int v = p.getValue();
        
        return v-1;
    }
}