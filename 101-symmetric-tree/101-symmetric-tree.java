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
    public boolean ifMirror(TreeNode lroot, TreeNode rroot){
        if((lroot == null && rroot != null) || (lroot != null && rroot == null)){
            return false;
        }
        
        if(lroot == null && rroot == null){
            return true;
        }
        
        if(lroot.val != rroot.val){
            return false;
        }
        
        return ifMirror(lroot.left, rroot.right) && ifMirror(lroot.right, rroot.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        
        return ifMirror(root.left, root.right);
    }
}