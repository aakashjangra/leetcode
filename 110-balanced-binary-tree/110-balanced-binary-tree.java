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
    public int heightOfTree(TreeNode root, int height){
        if(root != null){
            int l = heightOfTree(root.left, height + 1);
            int r = heightOfTree(root.right, height + 1);
            if(Math.abs(l-r) > 1){
                l = Integer.MAX_VALUE;
            }
            return Math.max(l, r);
        }
        return height;
    }
    public boolean isBalanced(TreeNode root) {
        
        return heightOfTree(root, 0) == Integer.MAX_VALUE? false: true;
    }
}