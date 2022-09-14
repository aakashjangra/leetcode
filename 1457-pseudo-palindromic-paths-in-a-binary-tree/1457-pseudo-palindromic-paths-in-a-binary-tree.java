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
    
    private void findPaths(TreeNode root, HashSet<Integer> set){
        if(root == null)    return;
        //if it's a leaf node
        
        if(set.contains(root.val)){
            set.remove(root.val);
        } else {
            set.add(root.val);
        }
        if(root.left == null && root.right == null){
            if(set.size() <= 1)
                ans++;
            return;
        } 
        
        findPaths(root.left, new HashSet(set));
        findPaths(root.right, new HashSet(set));
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        ans = 0;
        HashSet<Integer> set = new HashSet<>();
        
        findPaths(root, set);

        return ans;
    }
}