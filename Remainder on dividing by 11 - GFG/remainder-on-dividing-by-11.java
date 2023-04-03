//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  
        
        int t = Integer.parseInt(br.readLine()); 

        while(t > 0){
  
            String x = br.readLine(); 
            
            Solution ob = new Solution();
		
            System.out.println(ob.xmod11(x)); 

            t--;
        }
    } 
} 



// } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static int xmod11(String x)
	{    
	    int n = x.length();
	    int remainder = 0;
	    
	    for(int i = 0; i<n; i++){
	        int currentDigit = Integer.parseInt(x.charAt(i)+"");
	        int currentRemainder = (10*remainder + currentDigit) % 11;
	       // System.out.println("=> "+currentRemainder);
	        remainder = currentRemainder;
	    }
	    
	    return remainder;
	}
} 

