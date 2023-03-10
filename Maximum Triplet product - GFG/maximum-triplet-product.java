//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    Long maxTripletProduct(Long arr[], int n)
    {
        Long min = Long.MAX_VALUE, sMin = Long.MAX_VALUE;
        Long max = Long.MIN_VALUE, sMax = Long.MIN_VALUE, tMax = Long.MIN_VALUE;
        
        for(Long val: arr){
            if(min >= val){
                sMin = min;
                min = val;
            } else if(sMin >= val){
                sMin = val;
            }
            
            if(max <= val){
                tMax = sMax;
                sMax = max;
                max = val;
            } else if(sMax <= val){
                tMax = sMax;
                sMax = val;
            } else if(tMax <= val){
                tMax = val;
            }
        }
        
        //check 2 smallest * biggest or 3 biggest
        Long withNeg = min * sMin * max; //2 neg * pos
        Long biggestThree = max * sMax * tMax; //3 pos or last 3
        
        return Math.max(withNeg, biggestThree);
    }
}

//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    int sizeOfArray = Integer.parseInt(br.readLine());
		    
		    Long[] arr = new Long[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Long.parseLong(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    Long res = obj.maxTripletProduct(arr, sizeOfArray);
		    System.out.println(res);
		}
	}
}


// } Driver Code Ends