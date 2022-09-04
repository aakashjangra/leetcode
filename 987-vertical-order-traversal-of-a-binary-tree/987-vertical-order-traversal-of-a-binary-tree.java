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
    private void makeHeap(int r, int c, TreeNode root, PriorityQueue<int[]> minHeap){
        if(root == null)
            return;
        minHeap.add(new int[]{r, c, root.val});
        
        makeHeap(r+1, c-1, root.left, minHeap);
        makeHeap(r+1, c+1, root.right, minHeap);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] != b[1]? a[1] - b[1]: 
                                                                    a[0] != b[0]? a[0] - b[0]:
                                                                    a[2] - b[2]);
        
        makeHeap(0, 0, root, minHeap);
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> col_list = new ArrayList<>();
        int[] first = minHeap.poll();
        int prev_col = first[1];
        col_list.add(first[2]);
        
        while(!minHeap.isEmpty()){
            int[] arr = minHeap.poll();
            int r = arr[0];
            int c = arr[1];
            int v = arr[2];

            if(c == prev_col)
                col_list.add(v);
            else {
                ans.add(col_list);
                col_list = new ArrayList<>();
                col_list.add(v);
            }
            
            prev_col = c;
        }
        
        ans.add(col_list);
        
        return ans;
    }
}