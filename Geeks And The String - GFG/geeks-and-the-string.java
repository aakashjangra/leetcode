//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.removePair(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String removePair(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        int n = s.length();
        for(int i = 0; i<n; i++){
            char c = s.charAt(i);
            if(!stack.isEmpty() && stack.peek() == c){
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        
        int len = stack.size();
        if(len == 0) return "-1";
        
        char[] chars = new char[n];
        len--;
        
        while(!stack.isEmpty()){
            chars[len--] = stack.pop();
        }
        
        return new String(chars);
    }
}
        
