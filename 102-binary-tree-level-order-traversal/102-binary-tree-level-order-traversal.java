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
    public List<List<Integer>> levelOrder(TreeNode root) {
       
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        Queue<TreeNode> que = new LinkedList<>();
        
         if(root == null){
            return answer;
        }
        
        que.add(root);
        
        while(que.size() != 0){
            List<Integer> level = new ArrayList<Integer>();
            int n = que.size();
            while(n > 0){
                TreeNode curr = que.peek();
                if(curr.left != null){
                    que.offer(curr.left);
                }
                if(curr.right != null){
                    que.offer(curr.right);
                }
                
                level.add(que.poll().val);
                n--;
                
            }
            
            answer.add(level);
        }
        
        return answer;
    }
}