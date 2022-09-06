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
    private void helper(TreeNode root, int val, int l, int r){
        if(root == null)    return;
        
        //if leaf node, check if we can attack node with val(value) to it's left or right
        if(root.left == null && l < val && val < root.val){
                root.left = new TreeNode(val);
                return;
        }
        
        if(root.right == null && root.val < val && val < r){
                root.right = new TreeNode(val);
                return;
        }
        
        helper(root.left, val, l, root.val);
        helper(root.right, val, root.val, r);
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        if(root == null)    return new TreeNode(val);
        
        helper(root, val, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return root;
    }
}