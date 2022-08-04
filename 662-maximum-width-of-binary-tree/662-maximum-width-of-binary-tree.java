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
    
    private int getWidth(TreeNode root, int level, int index, ArrayList<Integer> start, ArrayList<Integer> end){
        if(root == null) return 0;
        
        if(start.size() == level){
            start.add(index);
            end.add(index);
        } else {
            end.add(level, index);
        }
        
        int curr = end.get(level) - start.get(level) + 1;
        int left = getWidth(root.left, level+1, index*2, start, end);
        int right = getWidth(root.right, level+1, (index*2) + 1, start, end);
        
        return Math.max(curr, Math.max(left, right));
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        
        return getWidth(root, 0, 1, new ArrayList<Integer>(), new ArrayList<Integer>());
        
    }
}