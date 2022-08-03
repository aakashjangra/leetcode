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
    private void fillStack(TreeNode root, Stack<TreeNode> st){
        if(root == null) return;
        fillStack(root.right, st);
        st.push(root);
        fillStack(root.left, st);
    }
    public TreeNode increasingBST(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        fillStack(root, st);
        root = st.pop();
        TreeNode temp = root;
        while(st.size() != 0){
            temp.left = null;
            temp.right = st.peek();
            temp = st.pop();
        }
        temp.right = null;
        temp.left = null;
        return root;
    }
}