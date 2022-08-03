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
    public int getSum(TreeNode root, boolean left, int sum){
        if(root == null)
            return sum;
        if(root.left == null && root.right == null){
            if(left){
                sum += root.val;
            }
            return sum;
        }
        
        return getSum(root.left, true, sum)+getSum(root.right, false, sum);
    }
    public int sumOfLeftLeaves(TreeNode root) {
        
        return getSum(root, false, 0);
    }
}