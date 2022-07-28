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
    public int calculate(TreeNode root, int total){
           
        if(root != null){
            total = total*2 + root.val;
            if(root.left == null && root.right == null){
                return total;
            }
            return calculate(root.left, total) + calculate(root.right, total);
        }

        return 0;
    }
    public int sumRootToLeaf(TreeNode root) {
        return calculate(root, 0);
    }
}