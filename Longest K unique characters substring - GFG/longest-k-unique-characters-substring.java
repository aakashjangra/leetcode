//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        Map<Character, Integer> freq = new HashMap<>();
        int i = 0, j = 0;
        int n = s.length();
        int longest = -1;
        
        while(j < n){
            char cur = s.charAt(j);
            freq.put(cur, freq.getOrDefault(cur, 0) + 1);
            
            if(freq.size() > k){
                while(!freq.isEmpty() && i < j && freq.size() > k){
                    char c = s.charAt(i);
                    i++;
                    int count = freq.get(c);
                    if(count == 1){
                        freq.remove(c);
                    } else {
                        freq.put(c, count - 1);
                    }
                }
            }
            
            if(freq.size() == k){
                longest = Math.max(longest, j - i + 1); //current window size
            }
            
            j++;
        }
        
        return longest;
    }
}