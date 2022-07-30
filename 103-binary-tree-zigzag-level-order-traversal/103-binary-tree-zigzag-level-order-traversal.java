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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        if(root == null){
            return new ArrayList();
        }
        
        Queue<TreeNode> que = new LinkedList();
        List<List<Integer>> answer = new ArrayList();
        
        que.add(root);
        que.add(null);
        List<Integer> thisLevel = new ArrayList();
        boolean zigZag = false;
        
        while(que.size() > 1){
            TreeNode curr = que.poll();
            
            if(curr != null){
                thisLevel.add(curr.val);
        
                if(curr.left != null)
                que.offer(curr.left);
                if(curr.right != null)
                que.offer(curr.right);
                
            } else {
                if(zigZag){
                    Collections.reverse(thisLevel);
                    zigZag = false;
                } else {
                    zigZag = true;
                }
                answer.add(thisLevel);
                que.offer(null);
                thisLevel = new ArrayList();
            }
        }
        
        if(zigZag){
            Collections.reverse(thisLevel);
        }
        answer.add(thisLevel);
        
        return answer;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}