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
    private boolean helper(int sum, TreeNode root, int target){
        if(root == null)
            return false;
        
        sum += root.val;
        if(root.left == null && root.right == null && target == sum)
            return true;
        
        return helper(sum, root.left, target) || helper(sum, root.right, target);    
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(0, root, targetSum);
    }
}