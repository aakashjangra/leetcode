//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int n = Integer.parseInt(element[0]);
		     
		    int arr [] = new int[n];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<n;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    Solution obj = new Solution();
		    int ans = obj.maxDistance(arr, n);
		    System.out.println(ans);
		}
	}
}




// } Driver Code Ends


//User function Template for Java


class Solution{
    
   
    // Function for finding maximum and value pair
    public static int maxDistance (int arr[], int n) {
        //Complete the function
        int smallest = arr[0], largest = arr[0], smallIndex = 0, largIndex = 0;
        int ans = 0;
        for(int i = 0; i<n; i++){
            ans = Math.max(ans, Math.abs(smallest - arr[i]) + Math.abs(smallIndex - i));
            ans = Math.max(ans, Math.abs(largest - arr[i]) + Math.abs(largIndex - i));
            
            if(arr[i] < smallest){
                int diff = Math.abs(arr[i] - smallest);
                int diffInIndex = Math.abs(i - smallIndex);
                if(diff > diffInIndex){
                    smallest = arr[i];
                    smallIndex = i;
                }
            }
            if(arr[i] > largest){
                int diff = Math.abs(arr[i] - largest);
                int diffInIndex = Math.abs(i - largIndex);
                if(diff > diffInIndex){
                    largest = arr[i];
                    largIndex = i;
                }
            }
        }
        
        return ans;
    }
    
    
}


