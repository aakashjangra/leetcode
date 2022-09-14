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
    private int ans;
    
    private void findPaths(TreeNode root, int path){
        if(root == null)    return;
        //if it's a leaf node
        
        path ^= 1 << root.val;
        
        if(root.left == null && root.right == null){
            if((path & (path-1)) == 0)
                ans++;
            return;
        } 
        
        findPaths(root.left, path);
        findPaths(root.right, path);
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        ans = 0;

        findPaths(root, 0);

        return ans;
    }
}