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
    public TreeNode makeTree(int ps, int pe, int is, int ie, Map<Integer, Integer> inomap, int []preorder, int []inorder){
        if(ps > pe || is > ie){
            return null;
        }
        int inoIndex = inomap.get(preorder[ps]);
        
        if(is == ie || ps == pe){
            return new TreeNode(inorder[inoIndex]);
        }
        int range = inoIndex - is;
        TreeNode root = new TreeNode(inorder[inoIndex]);
        root.left = makeTree(ps+1, ps+range, is, inoIndex-1, inomap, preorder, inorder);
        root.right = makeTree(ps+range+1, pe, inoIndex+1, ie, inomap, preorder, inorder);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inomap = new HashMap();
        for(int i = 0; i<inorder.length; i++){
            inomap.put(inorder[i], i);
        }
        
        return makeTree(0, preorder.length-1, 0, inorder.length-1, inomap, preorder, inorder);
    }
}