//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Position this line where user code will be pasted.
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.BalancedString(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private static String alphabets = "abcdefghijklmnopqrstuvwxyz";
    static String BalancedString(int N) {
        // code here
        
        String ans = "";
        if(N % 2 == 0){
            //even
            while(N > 0){
                if(N <= 26){
                    return ans + alphabets.substring(0, N/2) + alphabets.substring(26 - (N/2), 26);
                }
                
                ans += alphabets;
                N -= 26;
            }
        /*here things might need a change, might have to complete it 
        inside this loop itself to generate ans instead of 
        using recusion*/
        }
        
        int sumOfDigits = 0;
        int temp = N;
        while(temp > 0){
            sumOfDigits += temp%10;
            temp /= 10;
        }
        //odd
        //case 1: sum of digits of N is even
        if(sumOfDigits % 2 == 0){
            while(N > 0){
                if(N <= 26){
                    return ans + alphabets.substring(0, (N+1)/2) + alphabets.substring(26-((N-1)/2), 26);
                }
                
                ans += alphabets;
                N -= 26;
            }
            
        }
        //case 2: sum of digit of N is odd
        while(N > 0){
                if(N <= 26){
                    return ans + alphabets.substring(0, (N-1)/2) + alphabets.substring(26-((N+1)/2), 26);
                }
                
                ans += alphabets;
                N -= 26;
            }
            
        return alphabets + BalancedString(N-26);
    }
}