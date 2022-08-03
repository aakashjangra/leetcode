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
    public int calculateSum(TreeNode root, int low, int high, int sum){
        if(root == null)
            return sum;
        int curr = 0;
        if(low <= root.val && root.val <= high)
            curr += root.val;
        return curr + calculateSum(root.left, low, high, sum) + calculateSum(root.right, low, high, sum); 
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        return calculateSum(root, low, high, 0);
    }
}