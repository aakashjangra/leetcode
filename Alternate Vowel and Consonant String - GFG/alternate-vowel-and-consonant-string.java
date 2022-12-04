//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine().trim();
            
            Solution ob = new Solution();
            String ans = ob.rearrange(S, N);
            
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public String rearrange(String S, int N){
        StringBuilder vowels = new StringBuilder();
        StringBuilder consonants = new StringBuilder();
        for(int i = 0; i<N; i++){
            char c = S.charAt(i);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                vowels.append(c);
            } else {
                consonants.append(c);
            }
        }
        
        String vow = vowels.toString();
        String cons = consonants.toString();
        
        if(Math.abs(vow.length() - cons.length()) > 1) return "-1";
        
        char[] vowArr = vow.toCharArray();
        char[] consArr = cons.toCharArray();
        Arrays.sort(vowArr);
        Arrays.sort(consArr);
        vow = new String(vowArr);
        cons = new String(consArr);
        
        StringBuilder rearranged = new StringBuilder();
        boolean nowVow = true;
        int v = 0, c = 0;
        if(cons.length() > vow.length()){
            rearranged.append(cons.charAt(c));
            c++;
        } 
        
        if(cons.length() == vow.length()){
            if(cons.charAt(0) < vow.charAt(0)){
                nowVow = false;
            }
        }
        
        while(v < vow.length() || c < cons.length()){
            if(nowVow){
                rearranged.append(vow.charAt(v));
                v++;
            } else {
                rearranged.append(cons.charAt(c));
                c++;
            }
            nowVow = !nowVow;
        }
        return rearranged.toString();
    }
}