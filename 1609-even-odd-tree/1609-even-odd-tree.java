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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<TreeNode>();
        
        int level = 0;
        bfs.add(root);
        bfs.add(null);
        
        int iprev = Integer.MIN_VALUE;
        int dprev = Integer.MAX_VALUE;
        
        while(bfs.size() > 1){
            TreeNode curr = bfs.poll();
            if(curr != null){
                if(level%2 == 0){
                    if(iprev >= curr.val || curr.val%2 == 0){
                        return false;
                    } 
                    iprev = curr.val;
                } else {
                    if(dprev <= curr.val || curr.val%2 != 0){
                        return false;
                    } 
                    dprev = curr.val;
                }
                if(curr.left != null)
                    bfs.offer(curr.left);
                if(curr.right != null)
                    bfs.offer(curr.right);
            } else {
                level++;
                bfs.offer(null);
                iprev = Integer.MIN_VALUE;
                dprev = Integer.MAX_VALUE;
            }
        }
        
        return true;
    }
}