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

    private int ans;
    
    class myvar{
        int min;
        int max;
        int sum;
        myvar(int mini, int maxi, int s){
            min = mini;
            max = maxi;
            sum = s;
        }
    }
    
    private myvar getSum(TreeNode root){
        if(root == null)    return new myvar(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        myvar lvar = getSum(root.left);
        myvar rvar = getSum(root.right);
        int lmin = lvar.min;
        int lmax = lvar.max;
        int lsum = lvar.sum;
        int rmin = rvar.min;
        int rmax = rvar.max;
        int rsum = rvar.sum;
        
        if(lmax < root.val && root.val < rmin){
            int cmin = Math.min(lmin, root.val);
            int cmax = Math.max(rmax, root.val);
            int sum = lsum + rsum + root.val;
            ans = Math.max(sum , ans);
            return new myvar(cmin, cmax, sum);
        } 
        
        return new myvar(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }
    
    public int maxSumBST(TreeNode root) {
        ans = 0;
        getSum(root);
        return ans;
    }
}