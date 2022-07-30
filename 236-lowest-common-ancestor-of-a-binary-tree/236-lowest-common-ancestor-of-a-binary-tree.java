/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root != null){
            if(root.val == p.val){
                return p;
            } 
            if(root.val == q.val){
                return q;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);  
            if(left != null && right != null){
                return root;
            }
            return left != null? left: right;
        }
        
        return null;
    }
}