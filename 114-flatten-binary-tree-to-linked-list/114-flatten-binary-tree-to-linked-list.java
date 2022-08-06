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
    private void preorder(TreeNode root, Queue<TreeNode> q){
        if(root == null)    return;
        q.offer(root);
        preorder(root.left, q);
        preorder(root.right, q);
    }
    public void flatten(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();
        preorder(root, q);
        
        while(q.size() > 0){
            TreeNode curr = q.poll();
            curr.left = null;
            curr.right = q.peek();
        }
    
    }
}