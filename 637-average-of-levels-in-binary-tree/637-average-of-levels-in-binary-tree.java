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
        Queue<TreeNode> levelOrder = new LinkedList<>();
        List<Double> ans = new ArrayList<>();
        
        levelOrder.offer(root);
        levelOrder.offer(null);
        while(levelOrder.size() > 1){
            TreeNode current = levelOrder.poll();
            Double sum = 0d;
            int total = 0;
            TreeNode iter = current;
            while(iter != null){
                sum += iter.val;
                total++;
                if(iter.left != null)
                    levelOrder.offer(iter.left);
                if(iter.right != null)
                    levelOrder.offer(iter.right);
                iter = levelOrder.poll();
            }
            if(current != null){
                ans.add(sum/total);                
                levelOrder.offer(null);
            }
        }
        
        return ans;
    }
}