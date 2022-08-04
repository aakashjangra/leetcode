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
    class Pair{
        TreeNode node;
        int num;
        Pair(TreeNode n, int val){
            node = n;
            num = val;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        
        int ans = 0;
        
        Queue<Pair> levelOrder = new LinkedList<>();
        
        levelOrder.offer(new Pair(root, 0));
        
        while(!levelOrder.isEmpty()){
            int size = levelOrder.size();
            int lmin = levelOrder.peek().num;
            int first = 0, last = 0;
                
            for(int i = 0; i<size; i++){
                int curr = levelOrder.peek().num-lmin;
                TreeNode currNode = levelOrder.peek().node;
                levelOrder.poll();
                
                if(i == 0) first = curr;
                if(i == size-1) last = curr;
                
                if(currNode.left != null){
                    levelOrder.offer(new Pair(currNode.left, (curr*2)+1));
                }
                if(currNode.right != null){
                    levelOrder.offer(new Pair(currNode.right, (curr*2)+2));
                }
            }
            
            ans = Math.max(ans, last-first+1);
        }
            
        return ans;
    }
}