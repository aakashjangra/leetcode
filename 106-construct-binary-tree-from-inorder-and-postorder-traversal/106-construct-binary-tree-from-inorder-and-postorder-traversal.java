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
    public TreeNode buildForMe(int ps, int pe, int is, int ie, int []inorder, int []postorder, Map<Integer, Integer> inomap){
        if(ps > pe || is > ie){
            return null;
        }
        
        int inoIndex = inomap.get(postorder[pe]);
        int range = inoIndex - is;
        
        if(ps == pe || is == ie){
            return new TreeNode(inorder[inoIndex]);
        }
        
        TreeNode root = new TreeNode(inorder[inoIndex]);
        root.left = buildForMe(ps, ps+range-1, is, inoIndex-1, inorder, postorder, inomap); 
        root.right = buildForMe(ps+range, pe-1, inoIndex+1, inorder.length-1, inorder, postorder, inomap); 
        
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        Map<Integer, Integer> inomap = new HashMap();
        
        for(int i = 0; i<inorder.length; i++){
            inomap.put(inorder[i], i);
        }
        
        return buildForMe(0, postorder.length-1, 0, inorder.length-1, inorder, postorder, inomap); 
    }
}