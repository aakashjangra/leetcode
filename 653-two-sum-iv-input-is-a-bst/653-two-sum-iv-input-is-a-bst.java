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
    public boolean search(TreeNode root, TreeNode curr, int value){
        if(root == null) return false;
        
        return (curr != root && root.val == value) || search(root.left, curr, value) || search(root.right, curr, value);
    }
    public boolean helper(TreeNode root, TreeNode curr, int k){
        
        if(curr == null)    return false;
        
        return search(root, curr, k-curr.val) || helper(root, curr.left, k) || helper(root, curr.right, k);
    }
    public boolean findTarget(TreeNode root, int k) {
        
        return helper(root, root, k);
    }
}