//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(str[i]);
			Solution ob = new Solution();
			int [] ans = ob.nearestSmallestTower(arr);
			for(int i = 0; i < n; i++)
				System.out.print(ans[i]+" ");
			System.out.println();
		}
		
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution{
	int [] nearestSmallestTower(int [] arr){
	    //int[] -> {val, index}
		ArrayDeque<int[]> stack = new ArrayDeque<>();
		int n = arr.length;
		int[] left = new int[n];
		int[] right = new int[n];
		//left -> right
		for(int i = 0; i<n; i++){
		    int val = arr[i];
		    while(!stack.isEmpty() && stack.peek()[0] >= val){
		        stack.pop();
		    }
		    
		    if(stack.isEmpty()){
		        left[i] = -1;
		    } else {
		        left[i] = stack.peek()[1];
		    }
		    
		    stack.push(new int[]{val, i});
		}
		
		stack = new ArrayDeque<>();
		//right to left
		for(int i = n-1; i >= 0; i--){
		    int val = arr[i];
		    while(!stack.isEmpty() && stack.peek()[0] >= val){
		        stack.pop();
		    }
		    
		    if(stack.isEmpty()){
		        right[i] = -1;
		    } else {
		        right[i] = stack.peek()[1];
		    }
		    
		    stack.push(new int[]{val, i});
		}
		
		int[] ans = new int[n];
		for(int i = 0; i<n ;i++){
		    if(left[i] == -1 || right[i] == -1){
		        ans[i] = left[i] != -1? left[i]: right[i];
		    } else {
		        //see which is closest, is same then smaller index.
		        int l = Math.abs(left[i] - i);
		        int r = Math.abs(right[i] - i);
		        
		        if(l == r){
		            ans[i] = arr[left[i]] > arr[right[i]]? right[i]: left[i];
		        } else {
		            ans[i] = l < r? left[i]: right[i];
		        }
		    }
		}
		
		return ans;
	}
}