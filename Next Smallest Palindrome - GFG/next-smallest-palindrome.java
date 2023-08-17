//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int num[] = new int[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(str[i]);
            }

            Vector<Integer> ans = new Solution().generateNextPalindrome(num, n);
            for (Integer x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    Vector<Integer> generateNextPalindrome(int num[], int n) {
        int mid = (n-1)/2; //middle
        int index = mid;
        
        //matching
        while(index >= 0){
            if(num[index] != num[n-1-index]){
                break;
            }
            index--;
        }
        
        // System.out.println("index is-> "+index);
        
        if(index >= 0) {
            //replacement method/copying
            if(num[index] > num[n-1-index]){
                copyFromIndex(num, index, n);
            } else {
                index = -1;
            }
        }
        
        int carry = 0;
        if(index < 0){
            //given number is a palindrome/ add 1
            index = mid;
            carry = 1;
            while(carry == 1 && index >= 0){
                int number = num[index] + carry;
                carry = number/10;
                number = number%10;
                
                num[index] = number;
                num[n-1-index] = number;
                
                // System.out.print(index+"-"+number+" "+carry+" ");
                index--;
            }
            
            //copy remaining if any
            while(index >= 0){
                num[n-1-index] = num[index];
                index--;
            }
        } 
        
        // for(int val: num){
        //     System.out.print(val+" ");
        // }
        
        Vector<Integer> palindrome = new Vector<>();
        if(carry == 1){
            palindrome.add(1);
        }
        

        for(int val: num){
            palindrome.add(val);
        }

        
        if(carry == 1){
            palindrome.remove(n);
            palindrome.add(1);
        }
        
        return palindrome;
    }
    
    void copyFromIndex(int[] num, int index, int n){
        while(index >= 0){
            num[n-1-index] = num[index];
            index--;
        }
    }
}