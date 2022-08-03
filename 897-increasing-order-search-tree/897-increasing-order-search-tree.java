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
    private void getVals(TreeNode root, List<Integer> list){
        if(root == null) return;
        getVals(root.left, list);
        list.add(root.val);
        getVals(root.right, list);
    }
    public TreeNode increasingBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        getVals(root, list);
        
        TreeNode temp = root = new TreeNode(0);
        for(int a: list){
            temp.right = new TreeNode(a);
            temp = temp.right;
        }

        return root.right;
    }
}