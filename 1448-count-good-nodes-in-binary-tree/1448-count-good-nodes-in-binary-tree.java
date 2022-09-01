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
    private int helper(TreeNode root, int max){
        if(root == null)
            return 0;
        
        int count = 0;
        if(root.val >= max)
            count = 1;
        
        return count + helper(root.left, Math.max(max, root.val)) + helper(root.right, Math.max(max, root.val));
    }
    public int goodNodes(TreeNode root) {
        return helper(root, root.val);
    }
}