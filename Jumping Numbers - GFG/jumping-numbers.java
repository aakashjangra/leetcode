//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long X = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.jumpingNums(X));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static long jumpingNums(long X) {
        // code here
        long largestJumpingNumber = 1;
        Stack<Long> st = new Stack<>();
        for(int i = 1; i<=9; i++){
             if(i <= X)
                 st.push(new Long(i));
        }
        
        while(!st.isEmpty()){
            long num = st.pop();
            largestJumpingNumber = Math.max(largestJumpingNumber, num);
            
            //push 2 possibilities if valid
            int lastDigit = (int)(num%10);
            //1. appending lastDigit - 1 at the end
            if(lastDigit > 0){
                long jumpingNum1 = (num*10) + lastDigit - 1;
                if(jumpingNum1 <= X){
                    st.push(jumpingNum1);
                }
            }
            //1. appending lastDigit + 1 at the end
            if(lastDigit < 9){
                long jumpingNum1 = (num*10) + lastDigit + 1;
                if(jumpingNum1 <= X){
                    st.push(jumpingNum1);
                }
            }
        }
        
        return largestJumpingNumber;
    }
};