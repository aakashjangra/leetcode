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
    public List<Double> averageOfLevels(TreeNode root) {
        //queue for levelorder traversal of tree
        Queue<TreeNode> levelOrder = new LinkedList<>();
        //list of averages according to levels, i.e. 0 index contains average of all nodes at 0th level and so on...
        List<Double> ans = new ArrayList<>();
        //adding root in queue as we start traversal from level0
        levelOrder.offer(root);
        //adding null after that so that when null comes we know that it's the end of a level
        levelOrder.offer(null);
        
        //intializing sum and total with 0
        Double sum = 0d;
        int total = 0;
        
        while(levelOrder.size() > 1){
            TreeNode current = levelOrder.poll();
            
            if(current != null){
                sum += current.val;
                total++;
                if(current.left != null)
                    levelOrder.offer(current.left);
                if(current.right != null)
                    levelOrder.offer(current.right);
            } else {
                //storing average of a level = sum/total
                ans.add(sum/total);                
                levelOrder.offer(null);
                //resetting for another iteration
                sum = 0d;
                total = 0;
            }            
            
        }
        
        ans.add(sum/total);                
        
        return ans;
    }
}