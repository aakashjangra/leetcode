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
    public int maxPath(TreeNode root, boolean left, int depth){
        if(root != null){
            if(left){
                return Math.max(maxPath(root.left, true, 1), maxPath(root.right, false, depth+1));
            } else {
                return Math.max(maxPath(root.left, true, depth+1), maxPath(root.right, false, 1));
            }
        }
            
        return depth-1;
    }
    public int longestZigZag(TreeNode root) {
        return Math.max(maxPath(root.left, true, 1), maxPath(root.right, false, 1));
    }
}