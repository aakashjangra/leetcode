//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
	public static int addMinChar(String str){
	    int n = str.length();
	    int len = 1;
	    for(int e = n-1; e >= 1; e--){
	        if(palindrome(str, e)){
	            len = e + 1;
	            break;
	        }
	    }
	    
	    return n - len;
	}
	public static boolean palindrome(String str, int e){
	    int s = 0;
	    while(s < e){
	        if(str.charAt(s) != str.charAt(e)){
	            return false;
	        }
	        s++;
	        e--;
	    }
	    
	    return true;
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
        	String str = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.addMinChar(str));
        }
        
    }
}

// } Driver Code Ends