//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
import java.lang.*;


class GFG {
	public static void main (String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine()); // input size of array
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split("\\s+");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
		    }
		    Solve T = new Solve();
            long ans = T.maxArea(arr,n);
            System.out.println(ans);
		}
	}
}

// } Driver Code Ends


//User function Template for Java


class Solve{
    long maxArea(int arr[], int n){
        if(n == 1) return 0;
        
        long ansArea = 0;

        //calculating ans 
        int l = 0, r = n-1;
        while(l < r){
            long tempAns = Math.min(arr[l], arr[r]) * (r - l);
            ansArea = Math.max(ansArea, tempAns);
            
            if(arr[l] <= arr[r]) l++;
            else r--;
        }
        
        return ansArea;
    }
    
}