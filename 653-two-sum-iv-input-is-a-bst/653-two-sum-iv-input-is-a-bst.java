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
    public boolean inorder(TreeNode root, HashSet<Integer> set, int k){
        if(root == null)    return false;
        
        boolean left = inorder(root.left, set, k);
        
        boolean ans = false;
        if(set.contains(k - root.val))
            ans = true;
        set.add(root.val);
        
        boolean right = inorder(root.right, set, k);
        
        return ans || left || right;
    }
    public boolean findTarget(TreeNode root, int k) {
        
        HashSet<Integer> set = new HashSet<>();

        return inorder(root, set, k);
    }
}