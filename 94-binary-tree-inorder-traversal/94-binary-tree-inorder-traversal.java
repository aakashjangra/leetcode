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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if(root == null){
            return answer;
        }
        
        
        
        List<Integer> left = inorderTraversal(root.left);
        for(int i=0; i<left.size();  i++){
            answer.add(left.get(i));
        }
        
        answer.add(root.val);
        
        List<Integer> right = inorderTraversal(root.right);
        for(int i=0; i<right.size();  i++){
            answer.add(right.get(i));
        }
        
        return answer;
    }
}