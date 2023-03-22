//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  
        
        int t = Integer.parseInt(br.readLine()); 

        while(t > 0){
            
            String input_line1[] = br.readLine().trim().split("\\s+");
            int X = Integer.parseInt(input_line1[0]);
            int Y = Integer.parseInt(input_line1[1]);
            
            String S = br.readLine(); 
            
            Solution ob = new Solution();
		
            System.out.println(ob.solve(X,Y,S)); 

            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static long solve(int X,int Y, String S)
	{    
	    long x = 0, y = 0;
	    String s1 = "pr", s2 = "rp";
	    
	    if(Y > X){
	        s1 = "rp";
	        s2 = "pr";
	        int temp = X;
	        X = Y;
	        Y = temp;
	    }
	    
	    int len = S.length();
	    
	    while(S.indexOf(s1) != -1){
	        S = S.replaceAll(s1, "");
	    }
	    x = (len - S.length()) / 2;
	    
	    len = S.length();
	    
	    while(S.indexOf(s2) != -1){
	        S = S.replaceAll(s2, "");
	    }
	    y = (len - S.length()) / 2;
	    
	    return x*X + y*Y;
	}
} 
