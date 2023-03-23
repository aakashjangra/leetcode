//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GFG {
    
	public static void main (String[] args) throws Exception{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
	        while(t > 0){
	            int n=Integer.parseInt(br.readLine().trim());
	            String s[] = br.readLine().trim().split(" ");

	            int target=Integer.parseInt(br.readLine().trim());
    	    	Node root = null;
                for(int i=0;i<n;i++){
                    root=insert(root,Integer.parseInt(s[i]));
                }
        	    Solution g = new Solution();
        	    System.out.println(g.maxDifferenceBST(root,target));
                t--;
            
        }
    }

    public static Node insert(Node tree, int val) {
        Node temp = null;
        if (tree == null) return new Node(val);
    
        if (val < tree.data) {
            tree.left = insert(tree.left, val);
        } else if (val > tree.data) {
            tree.right = insert(tree.right, val);
        }
    
        return tree;
    }
  
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int maxDifferenceBST(Node root,int target)
    {
        Node targetNode = findTargetNode(root, target);
        if(targetNode == null) return -1;
        
        int sumUp = calculateSumUp(root, target);
        int sumDown = calculateSumDown(targetNode);
        
        // System.out.println(targetNode.data +" " +sumUp+" "+sumDown);
        
        return sumUp - sumDown;
    }
    public static Node findTargetNode(Node root, int target){
        if(root == null) return null;
        
        if(root.data == target) return root;
        
        Node left = findTargetNode(root.left, target);
        Node right = findTargetNode(root.right, target);
        
        return left != null? left: right;
    }
    public static int calculateSumUp(Node root, int target){
        if(root == null) return 0;
        
        if(target == root.data) return target;
        
        int left = 0, right = 0;
        
        if(target < root.data){
            left = calculateSumUp(root.left, target);
        } else if(target > root.data){
            right = calculateSumUp(root.right, target);
        }
        
        return root.data + left + right;
    }
    public static int calculateSumDown(Node root){
        if(root == null) return Integer.MAX_VALUE;
        
        //leaf node
        if(root.left == null && root.right == null) return root.data;
        
        int left = calculateSumDown(root.left);
        int right = calculateSumDown(root.right);
        
        return root.data + Math.min(left, right);
    }
}