//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String str;
            str = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.stringMirror(str);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String stringMirror(String str) {
        char first = str.charAt(0);
        char last = first;
        int i = 1;
        int n = str.length();
        
        while(i < n){
            char c = str.charAt(i);
            if(c > last || (c == last && c >= first)){
                break;
            }
            
            last = c;
            i++;
        }
        
        String prefix = str.substring(0, i);
        
        return prefix + rev(prefix);
    }
    private static String rev(String str){
        int n = str.length();
        int i = n-1;
        String reverse = "";
        while(i >= 0){
            reverse += str.charAt(i);
            i--;
        }
        
        return reverse;
    }
}
        
