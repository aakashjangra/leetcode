//{ Driver Code Starts
//Initial Template for Java
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.isSumOfTwo(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static boolean ifPrime(int num){
        if(num <= 1) return false;
        if(num == 2 || num == 3) return true;
        
        int n = 2;
        while(n <= num/2){
            if(num % n == 0) return false;
            n++;
        }
        
        return true;
    }
    static String isSumOfTwo(int N){
        // code here
        
        if(N < 4) return "No";
        
        if(N % 2 == 0) return "Yes";
        
        if(ifPrime(N-2)) return "Yes";
        
        return "No";
    }
}