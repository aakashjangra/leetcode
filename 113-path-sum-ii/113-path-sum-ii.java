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
    private void traverse(TreeNode root, int sum, List<Integer> path, int targetSum, List<List<Integer>> ans){
        if(root == null)    return;
        
        sum += root.val;
        path.add(root.val);
        //if leaf node 
        if(root.left == null && root.right == null){
            if(sum == targetSum)
                ans.add(new ArrayList<>(path));
            return;
        }
        
        //left subtree
        traverse(root.left, sum, path, targetSum, ans);
        if(root.left != null)
            path.remove(path.size()-1);
        
        //right subtree
        traverse(root.right, sum, path, targetSum, ans);
        if(root.right != null)
            path.remove(path.size()-1);

    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null)    return ans;
        
        traverse(root, 0, new ArrayList<>(), targetSum, ans);
        
        return ans;
    }
}