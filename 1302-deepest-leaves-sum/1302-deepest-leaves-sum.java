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
    public int createMap(TreeNode root, HashMap<Integer, Integer> map, int depth){
        if(root == null){
            return depth;
        }
        if(root.left == null && root.right == null){
            map.put(depth, map.getOrDefault(depth, 0)+root.val);
            return depth;
        }
        map.put(depth, map.getOrDefault(depth, 0)+root.val);
        return Math.max(createMap(root.left, map, depth+1), createMap(root.right, map, depth+1));
    }
    public int deepestLeavesSum(TreeNode root) {
        HashMap<Integer, Integer> map =  new HashMap<>();
        int maxDepth = createMap(root, map, 0);
        return map.get(maxDepth);
    }
}