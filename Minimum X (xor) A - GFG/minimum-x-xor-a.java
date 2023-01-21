//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            int a = Integer.parseInt(br.readLine().trim());
            int b = Integer.parseInt(br.readLine().trim());

            Solution ob = new Solution();
            out.println(ob.minVal(a, b));
        }
        out.flush();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int minVal(int a, int b) {
        int setA = countSetBits(a), setB = countSetBits(b);
        if(setA == setB) return a;
        
        if(setA > setB) return reduceBits(a, setA - setB);
        
        return increaseBits(a, setB - setA);
    }
    //find number of set bits
    public static int countSetBits(int num){
        int count = 0;
        while(num > 0){
            if((num & 1) == 1){
                //last bit is set
                count++;
            }
            //remove last bit
            num = num >> 1;
        }
        
        return count;
    }
    //reduced bits
    public static int reduceBits(int num, int count){
        int ans = 0;
        int place = 0;
        while(count > 0){
            //right se bits lo from num and left mei bits insert kro in newNum
            int last = num & 1;
            num >>= 1;
            
            if(last == 1){
                last = 0;
                count--;
            } 
            
            place++;
        }
        
        while(num > 0){
            int last = num & 1;
            num >>= 1;
            ans |= last << place;
            // System.out.println(ans);
            place++;
        }
        
        return ans;
    }
    //increased bits
    public static int increaseBits(int num, int count){
        int ans = 0;
        int place = 0;
        while(count > 0){
            //right se bits lo from num and left mei bits insert kro in newNum
            int last = num & 1;
            num >>= 1;
            
            if(last == 0){
                count--;
            } 
            
            ans |= 1 << place;
            place++;
        }
        
        while(num > 0){
            int last = num & 1;
            num >>= 1;
            ans |= last << place;
            // System.out.println(ans);
            place++;
        }
        
        return ans;
    }
}