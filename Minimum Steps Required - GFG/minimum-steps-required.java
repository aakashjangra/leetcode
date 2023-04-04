//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String str = br.readLine();
			Solution obj = new Solution();
			System.out.println(obj.minSteps(str));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int minSteps(String str) {
		char first = str.charAt(0);
		boolean flag = false;
		int n = str.length();
		
		int steps = 0;
		for(int i = 0; i<n; i++){
		    char c = str.charAt(i);
		    
		    if(c == first){
		        flag = false;
		    } else {
		        if(!flag){
		            steps++;
		        }
		        flag = true;
		    }
		    
		}
		
		return steps + 1;
	}
}