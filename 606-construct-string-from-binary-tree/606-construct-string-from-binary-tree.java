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
    private StringBuilder ans;
    private void makeString(TreeNode root){
        if(root == null) 
            return;
        
        ans.append(root.val);
        
        if(root.left == null && root.right == null)
            return ;
        
        ans.append('(');
        makeString(root.left);
        ans.append(')');
        
        if(root.right == null)  return;
        ans.append('(');
        makeString(root.right);
        ans.append(')');
        
        return;
    }
//     private void removeExtra(){

//         for(int i = 1; i<ans.length(); i++){
//             if(ans.charAt(i-1) == '(' && ans.charAt(i) == ')'){
//                 ans.delete(i-1, i+1);
//                 // System.out.println(ans);
//                 i -= 2;
//             }
//         }
        
//     }
    public String tree2str(TreeNode root) {
        ans = new StringBuilder();
        
        makeString(root);
        // removeExtra();
        
        return ans.toString();
    }
}