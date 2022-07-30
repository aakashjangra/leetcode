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
    public void mapValues(TreeNode root, Map<Integer, Integer> map, int level){
        if(root != null){
            map.put(level, root.val);
            mapValues(root.left, map, level+1);
            mapValues(root.right, map, level+1);
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ansList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        mapValues(root, map, 0);
        
        for(int val: map.values()){
            ansList.add(val);
        }

        return ansList;
    }
}